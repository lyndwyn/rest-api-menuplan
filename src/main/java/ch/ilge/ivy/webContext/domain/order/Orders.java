package ch.ilge.ivy.webContext.domain.order;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is the entity orders TODO
 * 
 * @author Laura Steiner
 *
 */
@ApiModel(value = "Order", description = "Order Entity")
@Entity
@Table(name = "orders")
public class Orders extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "amount_normal")
	private int amountNormal;
	
	@ApiModelProperty(required = true)
	@Column(name = "amount_nopork")
	private int amountNopork;
	
	@ApiModelProperty(required = true)
	@Column(name = "amount_vegi")
	private int amountVegi;
	
	@Column(name = "notice")
	private String notice;

	public Orders() {}
	
	public Orders(int amountNormal, int amountNopork, int amountVegi, String notice) {
		super();
		this.amountNormal = amountNormal;
		this.amountNopork = amountNopork;
		this.amountVegi = amountVegi;
		this.notice = notice;
	}
	
	public Orders(Long id, int amountNormal, int amountNopork, int amountVegi, String notice) {
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