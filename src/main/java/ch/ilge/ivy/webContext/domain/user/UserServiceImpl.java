package ch.ilge.ivy.webContext.domain.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;


/**
 * This class implements all data access related methods targeted towards the
 * entity users.
 * 
 * @author Laura Steiner
 */
@Service
public class UserServiceImpl extends ExtendedServiceImpl<User> implements UserService {
	
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * @param repository
	 */
	@Autowired
	UserServiceImpl(UserRepository repository, BCryptPasswordEncoder bCryptPasswordEncoder) {
		super(repository);
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = findByEmail(username);
		
		if (user == null) { throw new UsernameNotFoundException("User could not be found"); }
		return new UserDetailsImpl(user);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User findByEmail(String name) {
		User user = ((UserRepository) repository).findByEmail(name);
		return user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteByEmail(String name) {
		((UserRepository) repository).deleteByEmail(name);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public User getPrincipal() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		return ((UserDetailsImpl) loggedInUser.getPrincipal()).getUser();
	}
	
}
