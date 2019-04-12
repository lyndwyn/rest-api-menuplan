package ch.ilge.ivy.config.security;

import java.io.IOException;
import java.util.Optional;
import java.util.function.BiConsumer;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import ch.ilge.ivy.config.PropertyReader;
import ch.ilge.ivy.webContext.domain.user.User;
import ch.ilge.ivy.webContext.domain.user.UserDetailsImpl;
import ch.ilge.ivy.webContext.domain.user.UserService;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;

/**
 * This class handles the authorization and JWT parsing process.
 *
 * @author Laura Steiner
 */
class JWTAuthorizationFilter extends OncePerRequestFilter {
	
	private UserService userService;
	
	private AuthenticationManager authenticationManager;
	
	private PropertyReader propertyReader;
	
	BiConsumer<String, Exception> logger;
	
	/**
	 * @param authenticationManager
	 * @param userServiceImpl
	 * @param propertyReader
	 */
	JWTAuthorizationFilter(
			AuthenticationManager authenticationManager, UserService userService,
			PropertyReader propertyReader, BiConsumer<String, Exception> logger
	) {
		this.authenticationManager = authenticationManager;
		this.userService = userService;
		this.propertyReader = propertyReader;
		this.logger = logger;
	}
	
	/**
	 * This method aligns and compares header with internal properties
	 *
	 * @param req   Client request
	 * @param res   Response to client request
	 * @param chain Chain/Order of filters
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
			throws IOException, ServletException {
		String header = req.getHeader(propertyReader.getStringProperty("jwt.header-string"));
		if (header != null && header.startsWith(propertyReader.getStringProperty("jwt.token-prefix"))) {
			SecurityContextHolder.getContext().setAuthentication(getAuthentication(req, header));
		}
		chain.doFilter(req, res);
	}
	
	/**
	 * This method parses JWT and puts content into an authenticationToken
	 *
	 * @param  req    Client request
	 * @param  header Header string
	 * @return        UsernamePasswordAuthenticationToken
	 */
	private Authentication getAuthentication(HttpServletRequest req, String header) {
		String subject = null;
		try {
		subject = Jwts.parser().setSigningKey(propertyReader.getStringProperty("jwt.secret").getBytes())
				.parseClaimsJws(header.replace(propertyReader.getStringProperty("jwt.token-prefix"), "")).getBody()
				.getSubject();
		} catch (ExpiredJwtException ex) {
			logger.accept(String.format("Jwt expired for subject '%s'", subject), ex);
		}
		
		if (subject != null) {
			UserDetailsImpl userDetails =  new UserDetailsImpl(userService.findById(Long.parseLong(subject)).get());
			return new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
		}
		return null;
	}
	
}