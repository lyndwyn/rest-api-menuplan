package ch.ilge.ivy.webContext.domain.order;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.runner.RunWith; 
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;
import ch.ilge.ivy.webContext.domain.user.User;

@RunWith(MockitoJUnitRunner.class)
public class OrderServiceImplTest extends ExtendedServiceImplTest<OrderServiceImpl, Orders, OrderRepository> {
	
	@InjectMocks
	private OrderServiceImpl orderServiceImpl;
	
	@Mock
	private OrderRepository orderRepository;
	
	private Orders orderOne;
	private Orders orderTwo;
	private User userIvy;
	 
	@Before
	public void setup() {
		// Setup menus
		Menu menuNormal = new Menu("Pizza Prosciutto", 0, "Leckere Pizza.");
		Menu menuNoPork = new Menu("Pizza Margherita", 1, "Feine Pizza.");
		Set<Menu> menus = new HashSet<>(Arrays.asList(menuNormal, menuNoPork));
		
		// Setup Menuplan
		Menuplan menuplan = new Menuplan(1L, 16, menus, null);
		
		orderOne = new Orders(1L, 3, 0, 2, "Das ist eine Anmerkung.",  menuplan);
		orderTwo = new Orders(2L, 5, 10, 2, "Für Xy bitte kein Paprika auf die Pizza.",  menuplan);
		
		Set<Orders> orders = new HashSet<Orders>(Arrays.asList(orderOne, orderTwo));
		userIvy = new User(1L, "ivy@test.ch", "heinz", "Ivy", "Minoretti", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, null, orders);
		
		super.setup(orderServiceImpl,  orderRepository,  orderOne,  orderTwo);		
	}
		
}
