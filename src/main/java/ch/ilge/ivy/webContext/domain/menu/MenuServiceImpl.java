package ch.ilge.ivy.webContext.domain.menu;

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
}
