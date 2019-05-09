package ch.ilge.ivy.webContext.domain.menu;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
import ch.ilge.ivy.webContext.domain.menu.dto.MenuMapper;

/**
 * This is the JUnit-Test for the controller Menu.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(MenuController.class)
public class MenuControllerTest { 
	
	@Mock
	private MenuService menuService;
	
	@Mock
	private MenuMapper menuMapper;
	
	@InjectMocks
    private MenuController menuController;
	
	private MockMvc mockMvc;
	
	private Menu menuNormal;
	private Menu menuNoPork;
	private List<Menu> menus;
	
	private Menu menuToBeCreated;;
	private Menu menuToBeDeleted;
	
	  @Before
	    public void init(){
	        MockitoAnnotations.initMocks(this);
	        mockMvc = MockMvcBuilders
	                .standaloneSetup(menuController)
	                .build();
	        
	        // Setup
	        menuNormal = new Menu(1L, "Pizza Prosciutto", 0, "Leckere Pizza.");
			menuNoPork = new Menu(2L, "Pizza Margherita", 1, "Feine Pizza.");
			menuToBeCreated = new Menu("Pizza Vegi", 2, "Mit Pilz.");
			menuToBeDeleted = new Menu(3L, "Pizza Vegi", 2, "Mit Pilz und Paprika.");
			
			menus = new ArrayList<>();
			menus.add(menuNormal);
			menus.add(menuNoPork);
	  }
	  
	  /**
		 * This method tests if the getById(Long id) method works. It expect an Id and returns 
		 * the searched menu, if it exsists.
		 * 
		 * @throws JsonProcessingException
		 * @throws Exception
		 */
		@Test
		public void getById_givenId_returnsMenu() throws JsonProcessingException, Exception {
			
			when(menuService.findById(menuNormal.getId())).thenReturn(Optional.ofNullable(menuNormal));
			
			mockMvc.perform(MockMvcRequestBuilders.get("/menus/{id}", menuNormal.getId()))
				.andExpect(status().isOk());
		}
		
		/**
		 * This method tests if the getAll()-method works. 
		 * Returns all menus from the DB.
		 * 
		 * @throws JsonProcessingException
		 * @throws Exception
		 */
		@Test
		public void getAll_returnsAllMenus() throws JsonProcessingException, Exception {
			when(menuService.findAll()).thenReturn(menus);
			
			mockMvc.perform(MockMvcRequestBuilders.get("/menus"))
				.andExpect(status().isOk())
				.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
		}
		
		/**
		 * This method tests the create(Menu menu)-method.
		 * 
		 * @throws JsonProcessingException
		 * @throws Exception
		 */
		@Test
		public void create_givenMenu_returnsMenu() throws JsonProcessingException, Exception {
			doNothing().when(menuService).save(menuToBeCreated);
			
			mockMvc.perform(MockMvcRequestBuilders.post("/menus").contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(menuToBeCreated)))
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
			doNothing().when(menuService).save(menuNoPork);
			
			mockMvc.perform(MockMvcRequestBuilders.put("/menus/{id}", menuNoPork.getId(), menuNoPork).contentType(MediaType.APPLICATION_JSON)
				.content(new ObjectMapper().writeValueAsString(menuNoPork)))
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
			doNothing().when(menuService).delete(menuToBeDeleted);
			
			mockMvc.perform(MockMvcRequestBuilders
		            .delete("/menus/{id}", menuToBeDeleted.getId())
		            .contentType(MediaType.APPLICATION_JSON))
		            .andExpect(status().isNoContent());
		}
	
}
