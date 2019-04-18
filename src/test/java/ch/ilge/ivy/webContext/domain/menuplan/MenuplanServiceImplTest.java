package ch.ilge.ivy.webContext.domain.menuplan;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.order.Orders;


public class MenuplanServiceImplTest extends ExtendedServiceImplTest<MenuplanServiceImpl, Menuplan, MenuplanRepository> {
	
	@InjectMocks
	private MenuplanServiceImpl menuplanServiceImpl;
	
	@Mock
	private MenuplanRepository menuplanRepository;
	
	private Menuplan menuplanOne;
	private Menuplan menuplanTwo;
	
	@Before
	public void setup() {
		// Stores menus in the database
		Menu menuNormal = new Menu("Pizza Prosciutto", 0, "Leckere Pizza.");
		Menu menuNoPork = new Menu("Pizza Margherita", 1, "Feine Pizza.");
		Set<Menu> menus = new HashSet<>(Arrays.asList(menuNormal, menuNoPork));
		
		// Stores orders in database
		Orders orderOne = new Orders(3, 0, 2, "Das ist eine Anmerkung.",  null);
		Orders orderTwo = new Orders(5, 10, 2, "Für Xy bitte kein Paprika auf die Pizza.",  null);
		Set<Orders> orders = new HashSet<Orders>(Arrays.asList(orderOne, orderTwo));
		
		// Stores menuplan in the database
		menuplanOne = new Menuplan(1L, 16, menus, orders);
		menuplanTwo = new Menuplan(2L, 10, menus, orders);
		super.setup(menuplanServiceImpl, menuplanRepository, menuplanOne, menuplanTwo);
	}
}
