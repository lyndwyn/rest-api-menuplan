package ch.ilge.ivy.webContext.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;


import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.json.JSONException;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import ch.ilge.ivy.IvyTestApplication;
import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.role.Role;
import springfox.documentation.spring.web.json.Json;

import static io.restassured.RestAssured.*;
import static io.restassured.matcher.RestAssuredMatchers.*;
import static org.hamcrest.Matchers.*;


/**
 * TODO
 * @author Laura Steiner
 *
 */

//@ContextConfiguration(classes = IvyTestApplication.class)
//@WebMvcTest(UserController.class)
@RunWith(SpringRunner.class)
@SpringBootTest(classes = IvyTestApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {  
	
	@LocalServerPort
	private int port;
	 
    private String uri;
    
    TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();
	
	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
	
	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
	
		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/authorities"),
				HttpMethod.GET, entity, String.class);
	
		String expected = "[{id:1,name:WRITE},"
						+ "{id:2,name:READ},"
						+ "{id:3,name:EDIT},"
						+ "{id:4,name:MASTER}]";
	
		JSONAssert.assertEquals(expected, response.getBody(), false);
	}
 
    @PostConstruct
    public void init() {
        uri = "http://localhost:" + port;
    }
 
    @MockBean
    private UserService userService;
	
	
	/*
	@Test
	public void testRetrieveStudentCourse() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		//ResponseEntity<String> response = restTemplate.exchange(
		//		createURLWithPort("/users"),
		//		HttpMethod.GET, entity, String.class);
		
		ResponseEntity<String> response = restTemplate.withBasicAuth(
				  "ivy@test.ch", "heinz").exchange(
								createURLWithPort("/users"),
								HttpMethod.GET, entity, String.class);
		
				//.getForEntity("/users", 
				//  String.class);
		
		//String expected = "{\"email\":\"ivy@test.ch\",\"password\":\"$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy\",\"firstName\":\"Ivy\",\"lastName\":\"Musterfrau\",\"accountExpirationDate\":\"2020-01-01\",\"credentialsExpirationDate\":\"2019-12-31\",\"locked\":false,\"enabled\":true,\"roles\":[{\"name\":\"ADMIN\",\"authorities\":[{\"name\":\"READ\",\"id\":2},{\"name\":\"WRITE\",\"id\":1}],\"id\":1}],\"id\":1},{\"email\":\"vivienne@test.ch\",\"password\":\"$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy\",\"firstName\":\"Vivienne\",\"lastName\":\"Oberholzer\",\"accountExpirationDate\":\"2020-01-01\",\"credentialsExpirationDate\":\"2019-12-31\",\"locked\":false,\"enabled\":true,\"roles\":[{\"name\":\"USER\",\"authorities\":[{\"name\":\"READ\",\"id\":2}],\"id\":2}],\"id\":2},{\"email\":\"laa@test.ch\",\"password\":\"$2a$04$NJIdeWhWhwXFNJHna081iOg7o.FiyDjCI/C9MCFprUIVRuBSRHPGy\",\"firstName\":\"Laura\",\"lastName\":\"Steiner\",\"accountExpirationDate\":\"2019-01-31\",\"credentialsExpirationDate\":\"2020-01-12\",\"locked\":false,\"enabled\":true,\"roles\":[{\"name\":\"ADMIN\",\"authorities\":[{\"name\":\"WRITE\",\"id\":8},{\"name\":\"READ\",\"id\":7}],\"id\":5}],\"id\":3}";
		
		//JSONAssert.assertEquals(expected, response.getBody().value(), false);
		assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
	}
	
	@Test
	public void getUserById() {
		Authority authorityRead = new Authority("READ");
		Authority authorityWrite = new Authority("WRITE");
		Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));
		
		// Setup roles
		Role roleAdmin = new Role("Admin", authorities);
		Role roleEmployee = new Role("Employee", new HashSet<>(Arrays.asList(authorityRead)));
		Set<Role> roles = new HashSet<>(Arrays.asList(roleAdmin, roleEmployee));
		
		// Setup users
		User userIvy = new User(1L, "ivy@test.ch", "heinz", "Ivy", "Musterfrau", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, roles);
		
	    when(userService.findById(1L)).thenReturn(userIvy);
	 
	    //get(uri + "/user/" + userIvy.getId()).then()
	    //  .assertThat()
	    //  .statusCode(HttpStatus.OK.value())
	    //  .body("id", equals(userIvy.getId()))
	    //  .body("name", equals(userIvy.getEmail()))
	    //  .body("synopsis");
	}
	*/
}