package ch.ilge.ivy.webContext.domain.order.dto;

import ch.ilge.ivy.config.generic.ExtendedDTO;

/**
 * DTO for the Entity Orders.
 * 
 * @author Laura Steiner
 *
 */
public class OrderDTO extends ExtendedDTO {
	
	private Integer amountNormal;
	
	private Integer amountNopork;
	
	private Integer amountVegi;
	
	private String notice;
	
	private ExtendedDTO menuplan;
	
	public OrderDTO() {}

	/**
	 * 
	 * @param amountNormal
	 * @param amountNopork
	 * @param amountVegi
	 * @param notice
	 * @param menuplan
	 */
	public OrderDTO(Integer amountNormal, Integer amountNopork, Integer amountVegi, String notice, ExtendedDTO menuplan) {
		super();
		this.amountNormal = amountNormal;
		this.amountNopork = amountNopork;
		this.amountVegi = amountVegi;
		this.notice = notice;
		this.menuplan = menuplan;
	}
	
	/**
	 * 
	 * @param id
	 * @param amountNormal
	 * @param amountNopork
	 * @param amountVegi
	 * @param notice
	 * @param menuplan
	 */
	public OrderDTO(Long id, Integer amountNormal, Integer amountNopork, Integer amountVegi, String notice, ExtendedDTO menuplan) {
		super(id);
		this.amountNormal = amountNormal;
		this.amountNopork = amountNopork;
		this.amountVegi = amountVegi;
		this.notice = notice;
		this.menuplan = menuplan;
	}

	
	/**
	 * @return the amountNormal
	 */
	public Integer getAmountNormal() {
		return amountNormal;
	}

	
	/**
	 * @param amountNormal the amountNormal to set
	 */
	public void setAmountNormal(Integer amountNormal) {
		this.amountNormal = amountNormal;
	}

	
	/**
	 * @return the amountNopork
	 */
	public Integer getAmountNopork() {
		return amountNopork;
	}

	
	/**
	 * @param amountNopork the amountNopork to set
	 */
	public void setAmountNopork(Integer amountNopork) {
		this.amountNopork = amountNopork;
	}

	
	/**
	 * @return the amountVegi
	 */
	public Integer getAmountVegi() {
		return amountVegi;
	}

	
	/**
	 * @param amountVegi the amountVegi to set
	 */
	public void setAmountVegi(Integer amountVegi) {
		this.amountVegi = amountVegi;
	}

	
	/**
	 * @return the notice
	 */
	public String getNotice() {
		return notice;
	}

	
	/**
	 * @param notice the notice to set
	 */
	public void setNotice(String notice) {
		this.notice = notice;
	}

	
	/**
	 * @return the menuplan
	 */
	public ExtendedDTO getMenuplan() {
		return menuplan;
	}

	
	/**
	 * @param menuplan the menuplan to set
	 */
	public void setMenuplan(ExtendedDTO menuplan) {
		this.menuplan = menuplan;
	}

	
}
