package ch.ilge.ivy.webContext.domain.menu.dto;

import ch.ilge.ivy.config.generic.ExtendedDTO;

/**
 * DTO for the Entity Menu.
 * 
 * @author Laura Steiner
 *
 */
public class MenuDTO extends ExtendedDTO {
	
	private String name;
	
	private int type;
	
	private String description;
	
	public MenuDTO() {}

	/**
	 * 
	 * @param name
	 * @param type
	 * @param description
	 */
	public MenuDTO(String name, int type, String description) {
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
	public MenuDTO(Long id, String name, int type, String description) {
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
