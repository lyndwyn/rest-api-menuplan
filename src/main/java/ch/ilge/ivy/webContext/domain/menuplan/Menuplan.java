package ch.ilge.ivy.webContext.domain.menuplan;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import ch.ilge.ivy.config.generic.ExtendedEntity;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.order.Orders;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * This class is the Entity Menuplan. A Menuplan can hold multiple menus.
 * 
 * @author Laura Steiner
 */
@ApiModel(value = "Menuplans", description = "Menuplans Entity")
@Entity
@Table(name = "menuplan")
public class Menuplan extends ExtendedEntity {
	
	@ApiModelProperty(required = true)
	@Column(name = "calendar_week")
	private Integer calendarWeek;
	
	@ApiModelProperty(required = true)
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "menuplan_menu", joinColumns = @JoinColumn(name = "menuplan_id"), inverseJoinColumns = @JoinColumn(name = "menu_id"))
	private Set<Menu> menus;
	
	@OneToMany(
			cascade = CascadeType.ALL,
			fetch = FetchType.LAZY
		)
	private Set<Orders> orders;
	
	public Menuplan() {}

	/**
	 * 
	 * @param calendarWeek
	 * @param menus
	 * @param orders
	 */
	public Menuplan(Integer calendarWeek, Set<Menu> menus, Set<Orders> orders) {
		super();
		this.calendarWeek = calendarWeek;
		this.menus = menus;
		this.orders = orders;
	}

	/**
	 * 
	 * @param id
	 * @param calendarWeek
	 * @param menus
	 * @param orders
	 */
	public Menuplan(Long id, Integer calendarWeek, Set<Menu> menus, Set<Orders> orders) {
		super(id);
		this.calendarWeek = calendarWeek;
		this.menus = menus;
		this.orders = orders;
	}

	
	/**
	 * @return the calendarWeek
	 */
	public Integer getCalendarWeek() {
		return calendarWeek;
	}

	
	/**
	 * @param calendarWeek the calendarWeek to set
	 */
	public void setCalendarWeek(Integer calendarWeek) {
		this.calendarWeek = calendarWeek;
	}

	
	/**
	 * @return the menus
	 */
	public Set<Menu> getMenus() {
		return menus;
	}

	
	/**
	 * @param menus the menus to set
	 */
	public void setMenus(Set<Menu> menus) {
		this.menus = menus;
	}

	
	/**
	 * @return the orders
	 */
	public Set<Orders> getOrders() {
		return orders;
	}

	
	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<Orders> orders) {
		this.orders = orders;
	}
		
}
