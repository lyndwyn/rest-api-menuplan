package ch.ilge.ivy.webContext.domain.menu;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import ch.ilge.ivy.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Menu. 
 * 
 * @author Laura Steiner
 */
@ApiModel(value = "Menu", description = "Menu Entity")
@Entity
@Table(name = "menu")
public class Menu extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "name")
	private String name;
	
	@ApiModelProperty(required = true)
	@Column(name = "type")
	private int type;
	
	@Column(name = "description")
	private String description;

	public Menu() {}
	
	/**
	 * 
	 * @param name
	 * @param type
	 * @param description
	 */
	public Menu(String name, int type, String description) {
		super();
		this.name = name;
		this.type = type;
		this.description = description;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 * @param type
	 * @param description
	 */
	public Menu(Long id, String name, int type, String description) {
		super(id);
		this.name = name;
		this.type = type;
		this.description = description;
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
	 * @return the type
	 */
	public int getType() {
		return type;
	}

	
	/**
	 * @param type the type to set
	 */
	public void setType(int type) {
		this.type = type;
	}

	
	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	
	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
}
