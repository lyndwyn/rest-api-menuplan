package ch.ilge.ivy.webContext.domain.authority;

import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;


/**
 * This class implements all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Laura Steiner
 *
 */
@Service
public class AuthorityServiceImpl extends ExtendedServiceImpl<Authority> implements AuthorityService {
	/**
	 * 
	 * @param repository
	 */
	public AuthorityServiceImpl(AuthorityRepository repository) {
		super(repository);
	}
}
