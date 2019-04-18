package ch.ilge.ivy.webContext.domain.role;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import ch.ilge.ivy.webContext.domain.authority.Authority;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


/**
 * This class is the entity role.
 * 
 * @author Laura Steiner
 */

@ApiModel(value = "Role", description = "Role Entity")
@Entity
@Table(name = "role")
public class Role extends ExtendedEntity {

	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "authority_role", joinColumns = @JoinColumn(name = "role_id"), inverseJoinColumns = @JoinColumn(name = "authority_id"))
	private Set<Authority> authorities = new HashSet<>();
	
	public Role() {}
	
	/**
	 * 
	 * @param name
	 */
	public Role(String name) {
		this.name = name;
	}

	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Role(Long id, String name) {
		super(id);
		this.name = name;
	}

	public Role(String name, Set<Authority> authorities) {
		super();
		this.name = name;
		this.authorities = authorities;
	}
	
	public Role(Long id, String name, Set<Authority> authorities) {
		super(id);
		this.name = name;
		this.authorities = authorities;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the authorities
	 */
	public Set<Authority> getAuthorities() {
		return authorities;
	}

	/**
	 * @param authorities the authorities to set
	 */
	public void setAuthorities(Set<Authority> authorities) {
		this.authorities = authorities;
	}
	
}
