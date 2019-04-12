package ch.ilge.ivy.webContext.domain.role;

import org.springframework.stereotype.Repository;

import ch.ilge.ivy.config.generic.ExtendedJpaRepository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity role.
 * 
 * @author Laura Steiner
 *
 */
@Repository
public interface RoleRepository extends ExtendedJpaRepository<Role> {

}
