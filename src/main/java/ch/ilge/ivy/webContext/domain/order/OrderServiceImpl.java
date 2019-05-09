package ch.ilge.ivy.webContext.domain.order;

import java.util.Calendar;
import java.util.Date;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ch.ilge.ivy.config.generic.ExtendedServiceImpl;
import ch.ilge.ivy.webContext.domain.user.User;
import ch.ilge.ivy.webContext.domain.user.UserService;


/**
 * This class implements all data access related methods targeted towards the
 * entity orders.
 * 
 * @author Laura Steiner
 * 
 */
@Service
public class OrderServiceImpl extends ExtendedServiceImpl<Orders> implements OrderService {
	
	private UserService userService;
	
	/**
	 * 
	 * @param repository
	 */
	@Autowired
	public OrderServiceImpl(OrderRepository repository, UserService userService) {
		super(repository);
		this.userService = userService;
	}

	/**
	 *	This method checks if the user has an order for this week. 
	 * 	If yes true will be returned otherwise false.
	 *
	 * @param user The current logged in user
	 */
	@Override
	public boolean userHasOrderThisWeek(User user) {
		return getUserOrderForThisWeek(user).isPresent();
	}
	
	/**
	 * This method checks if the logged in user already has an order
	 * 
	 * @param user	The current logged in user
	 */
	@Override
	public Optional<Orders> getUserOrderForThisWeek(User user) {
		Calendar cal = Calendar.getInstance();
	    Date date = cal.getTime();
		cal.setTime(date);
		Integer week = cal.get(Calendar.WEEK_OF_YEAR);
		
		return user.getOrders().stream()
				.filter(order -> order.getMenuplan().getCalendarWeek() == week)
				.findAny();
	}
	
	/**
	 * This method adds an order to logged in users
	 * 
	 * @param order	The order to add
	 */
	@Override
	public void assignCurrentUser(Orders order) throws NoSuchElementException {
		var principal = userService.getPrincipal();
		principal.getOrders().add(order);
		userService.save(principal);
	}
}
