package ch.ilge.ivy.webContext.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

import ch.ilge.ivy.IvyTestApplication;
import ch.ilge.ivy.webContext.domain.authority.Authority;
import ch.ilge.ivy.webContext.domain.menu.Menu;
import ch.ilge.ivy.webContext.domain.menuplan.Menuplan;
import ch.ilge.ivy.webContext.domain.order.Orders;
import ch.ilge.ivy.webContext.domain.role.Role;


/**
 * 
 * @author Laura Steiner
 *
 */
@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = IvyTestApplication.class)
@DataJpaTest
public class UserRepositoryTest { 
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private User userLea;
	private User userIvy;
	
	@Before
	public void setup() {
		// Stores authorities in the database
		Authority authorityRead = new Authority("READ");
		Authority authorityWrite = new Authority("WRITE");
		entityManager.persist(authorityRead);
		entityManager.persist(authorityWrite);
		
		Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));
		
		// Stores roles in the database
		Role roleAdmin = new Role("Admin", authorities);
		Role roleEmployee = new Role("Employee", new HashSet<>(Arrays.asList(authorityRead)));
		entityManager.persist(roleAdmin);
		entityManager.persist(roleEmployee);
		Set<Role> roles = new HashSet<>(Arrays.asList(roleAdmin, roleEmployee));
		
		Set<Menu> menus = new HashSet<Menu>(new HashSet<Menu>(Arrays.asList(new Menu("Pizza Margherita", 1, "Feine Pizza."), new Menu("Pizza Prosciutto", 0, "Leckere Pizza."), new Menu("Vegetarische Pizza", 1, "Mit Paprika und Pilze."))));
		
		// Stores menuplan in the database
		Menuplan menuplan = new Menuplan(16, menus, null);
		
		// Stores orders in database
		Orders orderOne = new Orders(3, 0, 2, "Das ist eine Anmerkung.",  menuplan);
		Orders orderTwo = new Orders(5, 10, 2, "Bitte eine Pizza ohne Paprika.",  menuplan);
		entityManager.persist(orderOne);
		entityManager.persist(orderTwo);
		Set<Orders> orders = new HashSet<Orders>(Arrays.asList(orderOne, orderTwo));
		
		// Stores users in the database
		userIvy = new User("ivy@test.ch", "heinz", "Ivy", "Minoretti", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, roles, orders);
		userLea = new User("lea@test.ch", "heinz", "Lea", "Meier", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, true, roles, orders);
		
		entityManager.persist(userIvy);
		entityManager.persist(userLea);
	}
	
	@Test
	public void findByEmail_givenEmailDoesExist_returnsUser() {
		User userFromDB = userRepository.findByEmail(userLea.getEmail());
		assertThat(userLea).isEqualTo(userFromDB);
	}
	
	@Test
	public void findByEmail_givenEmailDoesNotExist_returnsNull() {
		User userFromDB = userRepository.findByEmail("UsernameNotAvailable");
		assertThat(userFromDB).isNull();
	}
	
	@Test
	public void deleteByEmail_givenEmailDoesExsist_deletesUser() {
		userRepository.deleteByEmail(userIvy.getEmail());
		assertThat(1).isEqualTo(userRepository.count());
		assertThat(userRepository.findByEmail(userIvy.getEmail())).isNull();
	}
	
	@Test
	public void deleteByEmail_givenEmailDoesNotExist_deletesNothing() {
		userRepository.deleteByEmail("UsernameNotAvailable");
		assertThat(2).isEqualTo(userRepository.count());
	}
	
}
