package ch.ilge.ivy.webContext.domain.menu;

import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	
	/**
	 * This method finds random Menus in the given category and count/amount
	 * 
	 * @param 	type		Type of the menu
	 * @param	count		How many menus should be returned
	 * @return	List<Menu>	List of random Menus
	 */
	@Query(nativeQuery = true, value = "SELECT * FROM menu WHERE type= :types ORDER BY RANDOM() LIMIT :count")
	Set<Menu> getRandomMenus(@Param("types") Integer type, 
							@Param("count") Integer count);
	
	
}
