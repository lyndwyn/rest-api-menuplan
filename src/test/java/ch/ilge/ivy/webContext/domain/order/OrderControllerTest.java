package ch.ilge.ivy.webContext.domain.order;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
 
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ilge.ivy.IvyTestApplication;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;
import ch.ilge.ivy.webContext.domain.order.dto.OrderMapper;
import ch.ilge.ivy.webContext.domain.user.User;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(OrderController.class) 
public class OrderControllerTest {
	

	private Orders orderOne;
	private Orders orderTwo;
	private List<Orders> orders;
	
	private Orders orderToBeCreated;
	private Orders orderToBeDeleted;
	
	private User userIvy;
	private Menuplan menuplan;
	
	private MockMvc mockMvc;
	
	@Mock
	private OrderService orderService;
	
	@InjectMocks
    private OrderController orderController;
	
	@Mock
	private OrderMapper orderMapper;
	
	@Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(orderController)
                .build();
        
     // Setup menus
	Menu menuNormal = new Menu("Pizza Prosciutto", 0, "Leckere Pizza.");
	Menu menuNoPork = new Menu("Pizza Margherita", 1, "Feine Pizza.");
	Set<Menu> menus = new HashSet<>(Arrays.asList(menuNormal, menuNoPork));
	
	// Setup Menuplan
	menuplan = new Menuplan(1L, 16, menus, null);
	
	orderOne = new Orders(1L, 3, 0, 2, "Das ist eine Anmerkung.",  menuplan);
	orderTwo = new Orders(2L, 5, 10, 2, "Für Xy bitte kein Paprika auf die Pizza.",  menuplan);
	
	orders = new ArrayList<>();
	orders.add(orderOne);
	orders.add(orderTwo);
	
	orderToBeCreated = new Orders(3, 0, 2, "Das ist eine Anmerkung.",  menuplan);
	orderToBeDeleted = new Orders(2L, 5, 10, 2, "Für Xy bitte kein Paprika auf die Pizza.",  menuplan);
	
	Set<Orders> orders = new HashSet<Orders>(Arrays.asList(orderOne, orderTwo));
	userIvy = new User(1L, "ivy@test.ch", "heinz", "Ivy", "Minoretti", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, null, orders);
        
	}
	
	/**
	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
	 * the searched order, if it exsists.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsOrder() throws JsonProcessingException, Exception {
		
		when(orderService.findById(orderOne.getId())).thenReturn(Optional.ofNullable(orderOne));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/orders/{id}", orderOne.getId()))
			.andExpect(status().isOk());
	}
	
	/**
	 * This method tests if the getAll()-method works. 
	 * Returns all orders from the DB.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsAllOrders() throws JsonProcessingException, Exception {
		when(orderService.findAll()).thenReturn(orders);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/orders"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
	
	/**
	 * This method tests the create(Orders order)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_userAlreadyHasOrderThisWeek_returnsBadRequest() throws JsonProcessingException, Exception {
		TestingAuthenticationToken testingAuthenticationToken = new TestingAuthenticationToken(userIvy, null);
        SecurityContextHolder.getContext().setAuthentication(testingAuthenticationToken);
		
		when(orderService.userHasOrderThisWeek(userIvy)).thenReturn(true); 
		
		mockMvc.perform(MockMvcRequestBuilders.post("/orders").contentType(MediaType.APPLICATION_JSON)
				.principal(testingAuthenticationToken))
				.andExpect(status().isBadRequest());
		
		// .content(new ObjectMapper().writeValueAsString(orderToBeCreated)))
	}
	
	/**
	 * This method tests if the updateById(Long id)-method works.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void updateById_givenId() throws JsonProcessingException, Exception {
		doNothing().when(orderService).save(orderTwo);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/orders/{id}", orderTwo.getId(), orderTwo).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(orderTwo)))
			.andExpect(status().isOk());
	}
	
	/**
	 * This method tests if the deleteById(Long id)-method works.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void deleteById_givenId() throws JsonProcessingException, Exception {
		doNothing().when(orderService).delete(orderToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/orders/{id}", orderToBeDeleted.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
}
