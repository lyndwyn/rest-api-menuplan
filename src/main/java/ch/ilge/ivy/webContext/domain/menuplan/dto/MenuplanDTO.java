package ch.ilge.ivy.webContext.domain.menuplan.dto;

import java.util.Set;

import ch.ilge.ivy.config.generic.ExtendedDTO;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.order.Orders;

/**
 * DTO for the Entity Menuplan.
 * 
 * @author Laura Steiner
 *
 */
public class MenuplanDTO extends ExtendedDTO {

	private int calendarWeek;
	
	private Set<Menu> menus;
	
	private Set<Orders> orders;
	
	public MenuplanDTO() {}

	/**
	 * 
	 * @param calendarWeek
	 * @param menus
	 * @param orders
	 */
	public MenuplanDTO(int calendarWeek, Set<Menu> menus, Set<Orders> orders) {
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
	public MenuplanDTO(Long id, int calendarWeek, Set<Menu> menus, Set<Orders> orders) {
		super(id);
		this.calendarWeek = calendarWeek;
		this.menus = menus;
		this.orders = orders;
	}

	/**
	 * @return the calendarWeek
	 */
	public int getCalendarWeek() {
		return calendarWeek;
	}

	/**
	 * @param calendarWeek the calendarWeek to set
	 */
	public void setCalendarWeek(int calendarWeek) {
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
