package ch.ilge.ivy.webContext.domain.order;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import ch.ilge.ivy.config.generic.ExtendedService;
import ch.ilge.ivy.webContext.domain.user.User;

/**
 * This interface holds all data access related method targeted towards the
 * entity orders.
 * 
 * @author Laura Steiner
 *
 */
public interface OrderService extends ExtendedService<Orders>{
	
	boolean userHasOrderThisWeek(User user);

	void assignCurrentUser(Orders orders) throws NoSuchElementException;

	Optional<Orders> getUserOrderForThisWeek(User user);
	
}
