package ch.ilge.ivy.webContext.domain.menuplan.dto;

import java.util.Set;

import ch.ilge.ivy.config.generic.ExtendedDTO;
import ch.ilge.ivy.webContext.domain.menu.dto.MenuDTO;

/**
 * This class is the Entity Menuplan. A Menuplan can hold multiple menus and 
 * have multiple orders from different users.
 * 
 * DTO for the Entity Menuplan.
 * 
 * @author Laura Steiner
 *
 */
public class MenuplanDTO extends ExtendedDTO {

	private Integer calendarWeek;
	
	private Set<MenuDTO> menus;
	
	private Set<ExtendedDTO> orders;
	
	public MenuplanDTO() {}

	/**
	 * 
	 * @param calendarWeek
	 * @param menus
	 * @param orders
	 */
	public MenuplanDTO(Integer calendarWeek, Set<MenuDTO> menus, Set<ExtendedDTO> orders) {
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
	public MenuplanDTO(Long id, Integer calendarWeek, Set<MenuDTO> menus, Set<ExtendedDTO> orders) {
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
	public Set<MenuDTO> getMenus() {
		return menus;
	}

	/**
	 * @param menus the menus to set
	 */
	public void setMenus(Set<MenuDTO> menus) {
		this.menus = menus;
	}

	/**
	 * @return the orders
	 */
	public Set<ExtendedDTO> getOrders() {
		return orders;
	}

	/**
	 * @param orders the orders to set
	 */
	public void setOrders(Set<ExtendedDTO> orders) {
		this.orders = orders;
	}
	
}
