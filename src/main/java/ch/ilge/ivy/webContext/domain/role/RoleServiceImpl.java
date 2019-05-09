package ch.ilge.ivy.webContext.domain.role;

import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;



/**
 * This class implements all data access related methods targeted towards the
 * entity role.
 * 
 * @author Laura Steiner
 *
 */
@Service
public class RoleServiceImpl extends ExtendedServiceImpl<Role> implements RoleService {

	/**
	 * 
	 * @param repository
	 */
	public RoleServiceImpl(RoleRepository repository) {
		super(repository);
	}

}
