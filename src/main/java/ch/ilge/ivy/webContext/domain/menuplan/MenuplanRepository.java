package ch.ilge.ivy.webContext.domain.menuplan;

import org.springframework.stereotype.Repository;

import ch.ilge.ivy.config.generic.ExtendedJpaRepository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity menuplan.
 * 
 * @author Laura Steiner
 */
@Repository
public interface MenuplanRepository extends ExtendedJpaRepository<Menuplan> {

}
