package ch.ilge.ivy.webContext.domain.order;

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
	
	/**
	 * This method checks if the user has an order for this week. 
	 * If yes true will be returned otherwise false.
	 * 
	 * @param user
	 * @return
	 */
	boolean userHasOrderThisWeek(User user);

	/**
	 * This method adds an order to logged in users
	 * 
	 * @param order	The order to add
	 */
	void assignCurrentUser(Orders orders) throws NoSuchElementException;

	/**
	 * This method checks if the logged in user already has made an order
	 * this week.
	 * 
	 * @param user	The current logged in user
	 */
	Optional<Orders> getUserOrderForThisWeek(User user);
	
}
