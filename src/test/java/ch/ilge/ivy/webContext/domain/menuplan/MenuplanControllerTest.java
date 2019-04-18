package ch.ilge.ivy.webContext.domain.menuplan;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ilge.ivy.IvyTestApplication;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menuplan.dto.MenuplanMapper;
import ch.ilge.ivy.webContext.domain.order.Orders;
 
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(MenuplanController.class)
public class MenuplanControllerTest {
	
	private Menuplan menuplanOne;
	private Menuplan menuplanTwo;
	private List<Menuplan> menuplans;
	
	private Menuplan menuplanToBeCreated;
	private Menuplan menuplanToBeDeleted;
	
	private MockMvc mockMvc;
	
	@Mock
    private MenuplanService menuplanService;

    @InjectMocks
    private MenuplanController menuplanController;
    
    @Mock
	private MenuplanMapper menuplanMapper;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(menuplanController)
                .build();
        
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
	
	menuplans = new ArrayList<>();
	menuplans.add(menuplanOne);
	menuplans.add(menuplanTwo);
	
	menuplanToBeCreated = new Menuplan(16, menus, orders);
	menuplanToBeDeleted = new Menuplan(2L, 10, menus, orders); 
    }
    
    /**
   	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
   	 * the searched menuplan, if it exsists.
   	 * 
   	 * @throws JsonProcessingException
   	 * @throws Exception
   	 */
   	@Test
   	public void getById_givenId_returnsMenuplan() throws JsonProcessingException, Exception {
   		
   		when(menuplanService.findById(menuplanOne.getId())).thenReturn(Optional.ofNullable(menuplanOne));
   		
   		mockMvc.perform(MockMvcRequestBuilders.get("/menuplans/{id}", menuplanOne.getId()))
   			.andExpect(status().isOk());
   	}
	
   	/**
	 * This method tests if the getAll()-method works. 
	 * Returns all authorities from the DB.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsAllMenuplans() throws JsonProcessingException, Exception {
		when(menuplanService.findAll()).thenReturn(menuplans);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/menuplans"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
	
	/**
	 * This method tests the create(Menuplan menuplan)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenMenuplan_returnsMenuplan() throws JsonProcessingException, Exception {
		doNothing().when(menuplanService).save(menuplanToBeCreated);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/menuplans").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(menuplanToBeCreated)))
			.andExpect(status().isCreated());
	}
	
	/**
	 * This method tests if the updateById(Long id)-method works.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void updateById_givenId() throws JsonProcessingException, Exception {
		doNothing().when(menuplanService).save(menuplanTwo);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/menuplans/{id}", menuplanTwo.getId(), menuplanTwo).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(menuplanTwo)))
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
		doNothing().when(menuplanService).delete(menuplanToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/menuplans/{id}", menuplanToBeDeleted.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
   	
}
