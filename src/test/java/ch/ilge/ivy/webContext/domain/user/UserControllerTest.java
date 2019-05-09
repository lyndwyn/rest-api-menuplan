package ch.ilge.ivy.webContext.domain.user;

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
import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.role.Role;
import ch.ilge.ivy.webContext.domain.user.dto.UserMapper;

/**
 * This is the JUnit-Test for the controller User.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(UserController.class)
public class UserControllerTest {
	
	@InjectMocks
	private UserController userController;
	
	@Mock
	private UserService userService;
	
	@Mock
	private UserMapper userMapper;
	
	private MockMvc mockMvc;
	
	private Role roleAdmin;
	private Role roleEmployee;
	
	private User userIvy;
	private User userLea;
	private User userToBeCreated;
	private User userToBeDeleted;
	private List<User> users;
	
	@Before
	public void setup() throws Exception {
		// Register all Models and DTOs for the mapping
		
		// Initialize mockMvc
		mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
		
		// Setup authority
		Authority authorityRead = new Authority("READ");
		Authority authorityWrite = new Authority("WRITE");
		Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));
		
		// Setup roles
		roleAdmin = new Role("Admin", authorities);
		roleEmployee = new Role("Employee", new HashSet<>(Arrays.asList(authorityRead)));
		Set<Role> roles = new HashSet<>(Arrays.asList(roleAdmin, roleEmployee));
		
		// Setup users
		userIvy = new User(1L, "ivy@test.ch", "heinz", "Ivy", "Minoretti", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, roles, null);
		userLea = new User(2L, "lea@test.ch", "heinz", "Lea", "Meier", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, true, roles, null);
		
		users = new ArrayList<>();
		users.add(userIvy);
		users.add(userLea);
		
		// User without an id for creation
		userToBeCreated = new User("vivi@test.ch", "1234", "Vivienne", "Oberholzer", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, roles, null);
		
		// User to be deleted
		userToBeDeleted = new User(3L, "tbd@test.ch", "4321", "To Be", "Deleted", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, true, roles, null);

	}
	

	/**
	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
	 * the searched user, if it exsists.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsUser() throws JsonProcessingException, Exception {
		
		when(userService.findById(userLea.getId())).thenReturn(Optional.ofNullable(userLea));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users/{id}", userLea.getId()))
			.andExpect(status().isOk());
	}
	
	/**
	 * This method tests if the getAll()-method works. 
	 * Returns all users from the DB.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsAllUsers() throws JsonProcessingException, Exception {
		when(userService.findAll()).thenReturn(users);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/users"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
	
	/**
	 * This method tests the create(User user)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenUser_returnsUser() throws JsonProcessingException, Exception {
		doNothing().when(userService).save(userToBeCreated);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/users").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(userToBeCreated)))
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
		doNothing().when(userService).save(userIvy);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/users/{id}", userIvy.getId(), userIvy).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(userIvy)))
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
		doNothing().when(userService).delete(userToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/users/{id}", userToBeDeleted.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
}
