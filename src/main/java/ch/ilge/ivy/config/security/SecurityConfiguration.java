package ch.ilge.ivy.config.security;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import ch.ilge.ivy.config.PropertyReader;
import ch.ilge.ivy.webContext.domain.user.UserService;



/**
 * This class is the main security context.
 *
 * @author Laura Steiner
 */
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, proxyTargetClass = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	private UserService userService;
	
	private BCryptPasswordEncoder pwEncoder;
	
	private PropertyReader propertyReader;
	
	private Logger errorLogger;
	
	/**
	 * @param userServiceImpl
	 * @param pwEncoder
	 */
	@Autowired
	public SecurityConfiguration(
			UserService userService, BCryptPasswordEncoder pwEncoder, @Qualifier("webErrorLogger") Logger errorLogger
	) {
		super();
		this.userService = userService;
		this.pwEncoder = pwEncoder;
		this.errorLogger = errorLogger;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService).passwordEncoder(pwEncoder);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		propertyReader = new PropertyReader("jwt.properties");
		http.cors().and().csrf().disable().authorizeRequests()
		.antMatchers("/welcome", "/login", "/v2/api-docs", "/swagger-resources/**", "/swagger-ui.html",
				"/webjars/**")
		.permitAll().anyRequest().authenticated().and()
		.addFilterAfter(
				new JWTAuthenticationFilter(new AntPathRequestMatcher("/login", "POST"),
						authenticationManagerBean(), propertyReader),
				UsernamePasswordAuthenticationFilter.class)
		.addFilterAfter(
				new JWTAuthorizationFilter(authenticationManagerBean(), userService, propertyReader, errorLogger::info),
				UsernamePasswordAuthenticationFilter.class)
		.httpBasic().and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
}
