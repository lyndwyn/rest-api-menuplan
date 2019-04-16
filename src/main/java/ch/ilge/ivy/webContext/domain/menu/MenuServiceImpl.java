package ch.ilge.ivy.webContext.domain.menu;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;


/**
 * This class implements all data access related methods targeted towards the
 * entity menu.
 * 
 * @author Laura Steiner
 *
 */
@Service
public class MenuServiceImpl extends ExtendedServiceImpl<Menu> implements MenuService {
	
	/**
	 * TODO comment
	 * @param repository
	 */
	public MenuServiceImpl(MenuRepository repository) {
		super(repository);
	}

	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<Menu> getRandomMenus() {
		Set<Menu> menus = new HashSet<Menu>();
		
		for(int i = 0; i < 3; i++) {
			menus.addAll(((MenuRepository) repository).getRandomMenus(i, 5));
		}
		
		return menus;
	}
}
