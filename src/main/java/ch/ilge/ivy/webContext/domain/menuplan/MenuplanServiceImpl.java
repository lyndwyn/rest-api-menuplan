package ch.ilge.ivy.webContext.domain.menuplan;

import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;


/**
 * This class implements all data access related methods targeted towards the
 * entity menuplan.
 * 
 * @author Laura Steiner
 * 
 */
@Service
public class MenuplanServiceImpl extends ExtendedServiceImpl<Menuplan> implements MenuplanService {
	/**
	 * TODO comment
	 * @param repository
	 */
	public MenuplanServiceImpl(MenuplanRepository repository) {
		super(repository);
	}
}
