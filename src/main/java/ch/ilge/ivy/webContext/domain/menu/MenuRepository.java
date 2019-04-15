package ch.ilge.ivy.webContext.domain.menu;

import org.springframework.stereotype.Repository;

import ch.ilge.ivy.config.generic.ExtendedJpaRepository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity menu.
 * 
 * @author Laura Steiner
 */
@Repository
public interface MenuRepository extends ExtendedJpaRepository<Menu> {

}
