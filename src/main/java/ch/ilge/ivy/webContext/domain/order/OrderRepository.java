package ch.ilge.ivy.webContext.domain.order;

import org.springframework.stereotype.Repository;

import ch.ilge.ivy.config.generic.ExtendedJpaRepository;


/**
 * This interface holds all data access related methods targeted towards the
 * entity orders.
 * 
 * @author Laura Steiner
 */
@Repository
public interface OrderRepository extends ExtendedJpaRepository<Orders> {

}
