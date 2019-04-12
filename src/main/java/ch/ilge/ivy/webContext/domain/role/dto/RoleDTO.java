package ch.ilge.ivy.webContext.domain.role.dto;

import java.util.HashSet;
import java.util.Set;

import ch.ilge.ivy.config.generic.ExtendedDTO;
import ch.ilge.ivy.webContext.domain.authority.dto.AuthorityDTO;

/**
 * TODO commi
 * @author Laura Steiner
 *
 */
public class RoleDTO extends ExtendedDTO {
	
	private String name;
	
	private Set<AuthorityDTO> authorityDTOs = new HashSet<>();
	
	/**
	 * 
	 */
	public RoleDTO() {
		super();
	}
	
	/**
	 * 
	 * @param name
	 * @param authorityDTOs
	 */
	public RoleDTO(String name, Set<AuthorityDTO> authorityDTOs) {
		super();
		this.name = name;
		this.authorityDTOs = authorityDTOs;
	}
	
	/**
	 * 
	 * @param id
	 * @param name
	 */
	public RoleDTO(Long id, String name, Set<AuthorityDTO> authorityDTOs) {
		super(id);
		this.name = name;
		this.authorityDTOs = authorityDTOs;
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
