package ch.ilge.ivy.webContext.domain.authority;

import org.springframework.stereotype.Repository;

import ch.ilge.ivy.config.generic.ExtendedJpaRepository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity authority.
 * 
 * @author Laura Steiner
 */
@Repository
public interface AuthorityRepository extends ExtendedJpaRepository<Authority> {

}
