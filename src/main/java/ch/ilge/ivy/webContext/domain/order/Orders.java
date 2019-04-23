package ch.ilge.ivy.webContext.domain.order;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This is the entity orders.
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
	private Integer amountNormal;
	
	@ApiModelProperty(required = true)
	@Column(name = "amount_nopork")
	private Integer amountNopork;
	
	@ApiModelProperty(required = true)
	@Column(name = "amount_vegi")
	private Integer amountVegi;
	
	@Column(name = "notice")
	private String notice;
	
	@ManyToOne(cascade = {CascadeType.ALL})
	private Menuplan menuplan;

	public Orders() {}

	/**
	 * 
	 * @param amountNormal
	 * @param amountNopork
	 * @param amountVegi
	 * @param notice
	 * @param menuplan
	 */
	public Orders(Integer amountNormal, Integer amountNopork, Integer amountVegi, String notice, Menuplan menuplan) {
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
	public Orders(Long id, Integer amountNormal, Integer amountNopork, Integer amountVegi, String notice, Menuplan menuplan) {
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
	public Menuplan getMenuplan() {
		return menuplan;
	}

	
	/**
	 * @param menuplan the menuplan to set
	 */
	public void setMenuplan(Menuplan menuplan) {
		this.menuplan = menuplan;
	}
	
}