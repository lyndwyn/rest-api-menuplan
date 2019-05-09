package ch.ilge.ivy.webContext.domain.user;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.role.Role;


/**
 * This class implements an additional layer of logic to the traditional entity
 * user.
 *
 * @author Laura Steiner
 */
public class UserDetailsImpl implements UserDetails {
	
	private User user;
	
	/**
	 *
	 */
	public UserDetailsImpl() {
		super();
	}
	
	/**
	 * @param user
	 */
	@Autowired
	public UserDetailsImpl(User user) {
		super();
		this.user = user;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		ArrayList<SimpleGrantedAuthority> grantedAuthorities = new ArrayList<>();
		for (Role role : user.getRoles()) {
			for (Authority authority : role.getAuthorities()) {
				grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
			}
		}
		return grantedAuthorities;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getPassword() {
		return user.getPassword();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getUsername() {
		return user.getEmail();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAccountNonExpired() {
		// implement account expired check
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isAccountNonLocked() {
		return !user.isLocked();
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isCredentialsNonExpired() {
		// implement credentials expired check
		return true;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean isEnabled() {
		return user.isEnabled();
	}
	
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}
}
