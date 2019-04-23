package ch.ilge.ivy.webContext.domain.user;

import java.sql.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

import com.fasterxml.jackson.annotation.JsonFormat;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import ch.ilge.ivy.webContext.domain.order.Orders;
import ch.ilge.ivy.webContext.domain.role.Role;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This class is the Entity User. A User can hold multiple roles with its own
 * authorities.
 * 
 * @author Laura Steiner
 */
@ApiModel(value = "User", description = "User Entity")
@Entity
@Table(name = "users")
public class User extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "email")
	private String email;
	
	@ApiModelProperty(required = true)
	@Column(name = "password")
	private String password;
	
	@ApiModelProperty(required = true)
	@Column(name = "first_name")
	private String firstName;
	
	@ApiModelProperty(required = true)
	@Column(name = "last_name")
	private String lastName;
	
	@ApiModelProperty(required = true)
	@Column(name = "account_expiration_date")
	@Type(type = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = "Europe/Zurich")
	private Date accountExpirationDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "credentials_expiration_date")
	@Type(type = "date")
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd", timezone = JsonFormat.DEFAULT_TIMEZONE)
	private Date credentialsExpirationDate;
	
	@ApiModelProperty(required = true)
	@Column(name = "locked")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean locked;
	
	@ApiModelProperty(required = true)
	@Column(name = "enabled")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean enabled;
	
	@ApiModelProperty(required = true)
	@Column(name = "living_goup")
	@Type(type = "org.hibernate.type.NumericBooleanType")
	private Boolean livingGroup;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "users_role", joinColumns = @JoinColumn(name = "users_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
	
	@OneToMany(
			cascade = CascadeType.REMOVE,
			fetch = FetchType.EAGER
		)
	@JoinColumn(name = "users_id")
	private Set<Orders> orders;
	
	
	public User() {}

	

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
	public User(String email, String password, String firstName, String lastName, Date accountExpirationDate,
			Date credentialsExpirationDate, Boolean locked, Boolean enabled, Boolean livingGroup, Set<Role> roles,
			Set<Orders> orders) {
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

	public User(Long id, String email, String password, String firstName, String lastName, Date accountExpirationDate,
			Date credentialsExpirationDate, Boolean locked, Boolean enabled, Boolean livingGroup, Set<Role> roles,
			Set<Orders> orders) {
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
	public Date getAccountExpirationDate() {
		return accountExpirationDate;
	}

	/**
	 * @param accountExpirationDate the accountExpirationDate to set
	 */
	public void setAccountExpirationDate(Date accountExpirationDate) {
		this.accountExpirationDate = accountExpirationDate;
	}

	/**
	 * @return the credentialsExpirationDate
	 */
	public Date getCredentialsExpirationDate() {
		return credentialsExpirationDate;
	}
	
	/**
	 * @param credentialsExpirationDate the credentialsExpirationDate to set
	 */
	public void setCredentialsExpirationDate(Date credentialsExpirationDate) {
		this.credentialsExpirationDate = credentialsExpirationDate;
	}
	
	/**
	 * @return the locked
	 */
	public Boolean isLocked() {
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
	public Boolean isEnabled() {
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
	public Set<Role> getRoles() {
		return roles;
	}

	/**
	 * @param roles the roles to set
	 */
	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}

	/**
	 * @return the orders
	 */
	public Set<Orders> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
	
}
