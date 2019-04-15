package ch.ilge.ivy.webContext.domain.order.dto;

import ch.ilge.ivy.config.generic.ExtendedDTO;

/**
 * DTO for the Entity Orders.
 * 
 * @author Laura Steiner
 *
 */
public class OrderDTO extends ExtendedDTO {
	
	private int amountNormal;
	
	private int amountNopork;
	
	private int amountVegi;
	
	private String notice;
	
	public OrderDTO() {}

	/**
	 * 
	 * @param amountNormal
	 * @param amountNopork
	 * @param amountVegi
	 * @param notice
	 */
	public OrderDTO(int amountNormal, int amountNopork, int amountVegi, String notice) {
		super();
		this.amountNormal = amountNormal;
		this.amountNopork = amountNopork;
		this.amountVegi = amountVegi;
		this.notice = notice;
	}
	
	/**
	 * 
	 * @param id
	 * @param amountNormal
	 * @param amountNopork
	 * @param amountVegi
	 * @param notice
	 */
	public OrderDTO(Long id, int amountNormal, int amountNopork, int amountVegi, String notice) {
		super(id);
		this.amountNormal = amountNormal;
		this.amountNopork = amountNopork;
		this.amountVegi = amountVegi;
		this.notice = notice;
	}

	
	/**
	 * @return the amountNormal
	 */
	public int getAmountNormal() {
		return amountNormal;
	}

	
	/**
	 * @param amountNormal the amountNormal to set
	 */
	public void setAmountNormal(int amountNormal) {
		this.amountNormal = amountNormal;
	}

	
	/**
	 * @return the amountNopork
	 */
	public int getAmountNopork() {
		return amountNopork;
	}

	
	/**
	 * @param amountNopork the amountNopork to set
	 */
	public void setAmountNopork(int amountNopork) {
		this.amountNopork = amountNopork;
	}

	
	/**
	 * @return the amountVegi
	 */
	public int getAmountVegi() {
		return amountVegi;
	}

	
	/**
	 * @param amountVegi the amountVegi to set
	 */
	public void setAmountVegi(int amountVegi) {
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
	
}
