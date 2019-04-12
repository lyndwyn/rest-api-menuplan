package ch.ilge.ivy.webContext.domain.authority.dto;

import ch.ilge.ivy.config.generic.ExtendedDTO;

/**
 * TODO commi
 * @author Laura Steiner
 *
 */
public class AuthorityDTO extends ExtendedDTO {
	
	private String name;
	
	/**
	 * 
	 */
	public AuthorityDTO() {
		super();
	}
	
	/**
	 * @param id
	 */
	public AuthorityDTO(Long id) {
		super(id);
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public AuthorityDTO(Long id, String name) {
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
