package ch.ilge.ivy.webContext.domain.authority;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the entity authority.
 * 
 * @author Laura Steiner
 *
 */
@ApiModel(value = "Authority", description = "Authority Entity")
@Entity
@Table(name = "authority")
public class Authority extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	public Authority() {}
	
	/**
	 * 
	 * @param name
	 */
	public Authority(String name) {
		this.name = name;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public Authority(Long id, String name) {
		super(id);
		this.name = name;
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

}
