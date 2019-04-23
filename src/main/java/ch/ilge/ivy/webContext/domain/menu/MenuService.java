package ch.ilge.ivy.webContext.domain.menu;

import java.util.List;

import ch.ilge.ivy.config.generic.ExtendedService;

/**
 * This interface holds all data access related method targeted towards the
 * entity menu.
 * 
 * @author Laura Steiner
 *
 */
public interface MenuService extends ExtendedService<Menu>{

	/**
	 * This method finds random Menus.
	 * 
	 * @return Set of Menus
	 */
	List<Menu> getRandomMenus();
	
}
