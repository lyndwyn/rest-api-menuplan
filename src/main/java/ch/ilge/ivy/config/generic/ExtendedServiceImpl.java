package ch.ilge.ivy.config.generic;

import java.util.List;
import java.util.Optional;

/**
 * This class that implements the CrudService.
 *
 * @author Laura Steiner
 * @param T Entity to be used. Childclass of ExtendedEntity
 */
public abstract class ExtendedServiceImpl<T extends ExtendedEntity> implements ExtendedService<T> {

	protected ExtendedJpaRepository<T> repository;

	/**
	 * @param repository
	 */
	public ExtendedServiceImpl(ExtendedJpaRepository<T> repository) {
		this.repository = repository;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void save(T entity) {
		repository.save(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void delete(T entity) {
		repository.delete(entity);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void deleteById(Long id) {
		repository.deleteById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void update(T entity) {
		repository.save(entity);

	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<T> findAll() {
		return repository.findAll();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Optional<T> findById(Long id) {
		return repository.findById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean existsById(Long id) {
		return repository.existsById(id);
	}

}
