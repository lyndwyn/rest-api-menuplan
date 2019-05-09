package ch.ilge.ivy.config.generic;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import com.fasterxml.jackson.annotation.JsonProperty;

import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;
import ch.ilge.ivy.webContext.domain.order.Orders;
import ch.ilge.ivy.webContext.domain.role.Role;
import ch.ilge.ivy.webContext.domain.user.User;
import io.swagger.annotations.ApiModel;


/**
 * This class covers the common attributes of all entities.
 * 
 * @author Laura Steiner
 */
@MappedSuperclass
@ApiModel(value = "ExtendedEntity", 
			discriminator = "SuperClass", 
			subTypes = {User.class, Authority.class, Menu.class, Menuplan.class, Orders.class, Role.class})
public abstract class ExtendedEntity {

	@Id
	@JsonProperty("id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	/**
	 *
	 */
	public ExtendedEntity() {
	}

	/**
	 * @param id
	 */
	public ExtendedEntity(Long id) {
		this.id = id;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
}