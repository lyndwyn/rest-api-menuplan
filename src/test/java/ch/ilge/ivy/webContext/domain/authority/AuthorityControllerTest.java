package ch.ilge.ivy.webContext.domain.authority;

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
import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.authority.dto.AuthorityMapper;

/**
 * This is the JUnit-Test for the controller Authority.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = IvyTestApplication.class)
@WebMvcTest(AuthorityController.class)
public class AuthorityControllerTest { 
	
	private MockMvc mockMvc;
	
	private Authority authorityRead;
	private Authority authorityWrite;
	private List<Authority> authorities;
	
	private Authority authorityToBeCreated;
	private Authority authorityToBeDeleted;

    @Mock
    private AuthorityService authorityService;

    @InjectMocks
    private AuthorityController authorityController;
    
    @Mock
	private AuthorityMapper authorityMapper;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
        mockMvc = MockMvcBuilders
                .standaloneSetup(authorityController)
                .build();
        
     // Setup authority
	authorityRead = new Authority(1L, "READ");
	authorityWrite = new Authority(2L, "WRITE");
	
	authorities = new ArrayList<>();
	authorities.add(authorityRead);
	authorities.add(authorityWrite);
	
	authorityToBeCreated = new Authority("READ");
	authorityToBeDeleted = new Authority(3L, "WRITE");
	 
    }
    
    /**
	 * This method tests if the getById(Long id) method works. It expect an Id and returns 
	 * the searched authority, if it exsists.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void getById_givenId_returnsAuthority() throws JsonProcessingException, Exception {
		
		when(authorityService.findById(authorityRead.getId())).thenReturn(Optional.ofNullable(authorityRead));
		
		mockMvc.perform(MockMvcRequestBuilders.get("/authorities/{id}", authorityRead.getId()))
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
	public void getAll_returnsAllAuthorities() throws JsonProcessingException, Exception {
		when(authorityService.findAll()).thenReturn(authorities);
		
		mockMvc.perform(MockMvcRequestBuilders.get("/authorities"))
			.andExpect(status().isOk())
			.andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE));
	}
	
	/**
	 * This method tests the create(Authority authority)-method.
	 * 
	 * @throws JsonProcessingException
	 * @throws Exception
	 */
	@Test
	public void create_givenAuthority_returnsAuthority() throws JsonProcessingException, Exception {
		doNothing().when(authorityService).save(authorityToBeCreated);
		
		mockMvc.perform(MockMvcRequestBuilders.post("/authorities").contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(authorityToBeCreated)))
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
		doNothing().when(authorityService).save(authorityWrite);
		
		mockMvc.perform(MockMvcRequestBuilders.put("/authorities/{id}", authorityWrite.getId(), authorityWrite).contentType(MediaType.APPLICATION_JSON)
			.content(new ObjectMapper().writeValueAsString(authorityWrite)))
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
		doNothing().when(authorityService).delete(authorityToBeDeleted);
		
		mockMvc.perform(MockMvcRequestBuilders
	            .delete("/authorities/{id}", authorityToBeDeleted.getId())
	            .contentType(MediaType.APPLICATION_JSON))
	            .andExpect(status().isNoContent());
	}
	
}
