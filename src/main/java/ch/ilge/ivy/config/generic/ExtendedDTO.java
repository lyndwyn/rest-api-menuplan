package ch.ilge.ivy.config.generic;

/**
 * This class covers the common attributes of all DTOs.
 * 
 * @author Laura Steiner
 */
public class ExtendedDTO { // not abstract so that DTOs can reference only-id nested entities
	
	private Long id;
	
	public ExtendedDTO() {
		super();
	}
	
	/**
	 * @param id
	 */
	public ExtendedDTO(Long id) {
		super();
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
