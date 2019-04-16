package ch.ilge.ivy.webContext.domain.order;

import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;


/**
 * This class implements all data access related methods targeted towards the
 * entity orders.
 * 
 * @author Laura Steiner
 * 
 */
@Service
public class OrderServiceImpl extends ExtendedServiceImpl<Orders> implements OrderService {
	/**
	 * TODO comment
	 * @param repository
	 */
	public OrderServiceImpl(OrderRepository repository) {
		super(repository);
	}
}
