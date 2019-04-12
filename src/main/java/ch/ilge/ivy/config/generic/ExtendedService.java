package ch.ilge.ivy.config.generic;

import java.util.List;
import java.util.Optional;

/**
 * This interface covers the basic CR related methods.
 *
 * @author Laura Steiner
 * @param T Entity to be used. Childclass of ExtendedEntity
 */
public interface ExtendedService<T extends ExtendedEntity> {

	/**
	 * This method saves the given entity
	 *
	 * @param entity The entity to be saved
	 */
	void save(T entity);

	/**
	 * This method updates the given entity
	 *
	 * @param entity The entity to be updated
	 */
	void update(T entity);

	/**
	 * This method deletes the given entity
	 *
	 * @param entity The entity to be deleted
	 */
	void delete(T entity);

	/**
	 * This method deletes an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 */
	void deleteById(Long id);

	/**
	 * This method finds all records of one entity
	 *
	 * @return Returns a list of all records of the given entity
	 */
	List<T> findAll();

	/**
	 * This method finds an entity with a given primary key
	 *
	 * @param id Primary key of entity
	 * @return Returns requested entity with given primary key id
	 */
	 Optional<T> findById(Long id);

	/**
	 * This method evaluates if the given id already exists
	 *
	 * @param id Primary key of entity
	 * @return Returns if the given id already exists
	 */
	boolean existsById(Long id);
}