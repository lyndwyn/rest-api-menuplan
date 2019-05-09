package ch.ilge.ivy.webContext.domain.role;

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
import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.role.dto.RoleMapper;

/**
 * This is the JUnit-Test for the controller Role.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(RoleController.class)
public class RoleControllerTest {
	
	private MockMvc mockMvc;
	
	private Role roleAdmin;
	private Role roleEmployee;
	private List<Role> roles;
	
	private Role roleToBeCreated;
	private Role roleToBeDeleted;

    @Mock
    private RoleService roleService;

    @InjectMocks
    private RoleController roleController;
    
    @Mock
	private RoleMapper roleMapper;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(roleController)
                .build();
        
     // Setup authority
	Authority authorityRead = new Authority("READ");
	Authority authorityWrite = new Authority("WRITE");
	Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));
	
	// Setup roles
	roleAdmin = new Role(1L, "Admin", authorities);
	roleEmployee = new Role(2L, "Employee", new HashSet<>(Arrays.asList(authorityRead)));
	roles = new ArrayList<>();
	roles.add(roleAdmin);
	roles.add(roleEmployee);
	
	roleToBeCreated = new Role("Admin", authorities);
	roleToBeDeleted = new Role(3L, "Employee", new HashSet<>(Arrays.asList(authorityRead)));
        
    }
    
    /**
	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
	 * the searched role, if it exsists.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsRole() throws JsonProcessingException, Exception {
		
		when(roleService.findById(roleAdmin.getId())).thenReturn(Optional.ofNullable(roleAdmin));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/roles/{id}", roleAdmin.getId()))
			.andExpect(status().isOk());
	}
	
	/**
	 * This method tests if the getAll()-method works. 
	 * Returns all roles from the DB.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getAll_returnsAllRoles() throws JsonProcessingException, Exception {
		when(roleService.findAll()).thenReturn(roles);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/roles"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
	
	/**
	 * This method tests the create(Role role)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenRole_returnsRole() throws JsonProcessingException, Exception {
		doNothing().when(roleService).save(roleToBeCreated);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/roles").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(roleToBeCreated)))
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
		doNothing().when(roleService).save(roleEmployee);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/roles/{id}", roleEmployee.getId(), roleEmployee).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(roleEmployee)))
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
		doNothing().when(roleService).delete(roleToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/roles/{id}", roleToBeDeleted.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
}
