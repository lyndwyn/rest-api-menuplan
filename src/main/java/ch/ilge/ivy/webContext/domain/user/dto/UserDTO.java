package ch.ilge.ivy.webContext.domain.user.dto;

import java.time.LocalDate;
import java.util.Set;

import ch.ilge.ivy.config.generic.ExtendedDTO;
import ch.ilge.ivy.webContext.domain.order.Orders;
import ch.ilge.ivy.webContext.domain.order.dto.OrderDTO;
import ch.ilge.ivy.webContext.domain.role.dto.RoleDTO;

/**
 * DTO for the Entity Users.
 * 
 * @author Laura Steiner
 *
 */
public class UserDTO extends ExtendedDTO {

	private String email;
	
	private String password;
	
	private String firstName;
	
	private String lastName;
	
	private LocalDate accountExpirationDate;
	
	private LocalDate credentialsExpirationDate;
	
	private Boolean locked;
	
	private Boolean enabled;
	
	private Boolean livingGroup;
	
	private Set<RoleDTO> roles;
	
	private Set<OrderDTO> orders;
	
	/**
	 * 
	 */
	public UserDTO() {
		super();
	}

	/**
	 * 
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 * @param livingGroup
	 * @param roles
	 * @param orders
	 */
	public UserDTO(String email, String password, String firstName, String lastName, LocalDate accountExpirationDate,
			LocalDate credentialsExpirationDate, Boolean locked, Boolean enabled, Boolean livingGroup, Set<RoleDTO> roles,
			Set<OrderDTO> orders) {
		super();
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
		this.livingGroup = livingGroup;
		this.roles = roles;
		this.orders = orders;
	}
	
	/**
	 * 
	 * @param id
	 * @param email
	 * @param password
	 * @param firstName
	 * @param lastName
	 * @param accountExpirationDate
	 * @param credentialsExpirationDate
	 * @param locked
	 * @param enabled
	 * @param livingGroup
	 * @param roles
	 * @param orders
	 */
	public UserDTO(Long id, String email, String password, String firstName, String lastName, LocalDate accountExpirationDate,
			LocalDate credentialsExpirationDate, Boolean locked, Boolean enabled, Boolean livingGroup, Set<RoleDTO> roles,
			Set<OrderDTO> orders) {
		super(id);
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.accountExpirationDate = accountExpirationDate;
		this.credentialsExpirationDate = credentialsExpirationDate;
		this.locked = locked;
		this.enabled = enabled;
		this.livingGroup = livingGroup;
		this.roles = roles;
		this.orders = orders;
	}

	
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	
	/**
	 * @return the accountExpirationDate
	 */
	public LocalDate getAccountExpirationDate() {
		return accountExpirationDate;
	}

	
	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(LocalDate accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	
	/**
	 * @return the credentialsExpirationDate
	 */
	public LocalDate getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}

	
	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(LocalDate credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}

	
	/**
	 * @return the locked
	 */
	public Boolean getLocked() {
		return locked;
	}

	
	/**
	 * @param locked the locked to set
	 */
	public void setLocked(Boolean locked) {
		this.locked = locked;
	}

	
	/**
	 * @return the enabled
	 */
	public Boolean getEnabled() {
		return enabled;
	}

	
	/**
	 * @param enabled the enabled to set
	 */
	public void setEnabled(Boolean enabled) {
		this.enabled = enabled;
	}

	
	/**
	 * @return the livingGroup
	 */
	public Boolean getLivingGroup() {
		return livingGroup;
	}

	
	/**
	 * @param livingGroup the livingGroup to set
	 */
	public void setLivingGroup(Boolean livingGroup) {
		this.livingGroup = livingGroup;
	}

	
	/**
	 * @return the roles
	 */
	public Set<RoleDTO> getRoles() {
		return roles;
	}

	
	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<RoleDTO> roles) {
		this.roles = roles;
	}

	
	/**
	 * @return the orders
	 */
	public Set<OrderDTO> getOrders() {
		return orders;
	}

	
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<OrderDTO> orders) {
		this.orders = orders;
	}
	
}
