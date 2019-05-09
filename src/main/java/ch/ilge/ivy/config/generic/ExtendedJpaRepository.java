package ch.ilge.ivy.config.generic;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This interface extends JPARepository and implements all methods which
 * are common among the domain repositories.
 *
 * @author Laura Steiner
 * @param T Entity to be used. Childclass of ExtendedEntity
 */
public interface ExtendedJpaRepository<T extends ExtendedEntity> extends JpaRepository<T, Long> {
	
}
