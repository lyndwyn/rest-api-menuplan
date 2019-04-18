package ch.ilge.ivy.webContext.domain.user;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;

import java.sql.Date;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;
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
@RunWith(MockitoJUnitRunner.class)
public class UserServiceImplTest extends ExtendedServiceImplTest<UserServiceImpl, User, UserRepository> {
	
	@InjectMocks
	private UserServiceImpl userServiceImpl;
	
	@Mock
	private UserRepository userRepository;
	
	private User userLea;
	private User userIvy;
	
	@Before
	public void setup() {
		// Stores authorities in the database
		Authority authorityRead = new Authority("READ");
		Authority authorityWrite = new Authority("WRITE");

		Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));

		// Stores roles in the database
		Role roleAdmin = new Role("Admin", authorities);
		Role roleEmployee = new Role("Employee", new HashSet<>(Arrays.asList(authorityRead)));
		Set<Role> roles = new HashSet<>(Arrays.asList(roleAdmin, roleEmployee));

		// Stores menus in the database
		Set<Menu> menus = new HashSet<Menu>(new HashSet<Menu>(Arrays.asList(new Menu("Pizza Margherita", 1, "Feine Pizza."), new Menu("Pizza Prosciutto", 0, "Leckere Pizza."), new Menu("Vegetarische Pizza", 1, "Mit Paprika und Pilze."))));

		// Stores menuplan in the database
		Menuplan menuplan = new Menuplan(16, menus, null);

		// Stores orders in database
		Orders orderOne = new Orders(3, 0, 2, "Das ist eine Anmerkung.",  menuplan);
		Orders orderTwo = new Orders(5, 10, 2, "Für Xy bitte kein Paprika auf die Pizza.",  menuplan);
		Set<Orders> orders = new HashSet<Orders>(Arrays.asList(orderOne, orderTwo));
				
		// Stores users in the database
		userIvy = new User(1L, "ivy@test.ch", "heinz", "Ivy", "Minoretti", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, false, roles, null);
		userLea = new User(2L, "lea@test.ch", "heinz", "Lea", "Meier", Date.valueOf("2020-01-01"), Date.valueOf("2020-01-01"), false, true, true, roles, null);
		
		super.setup(userServiceImpl,  userRepository,  userIvy,  userLea);
	}
	
	@Test
	public void findByUserName_givenUsernameDoesExist_returnsUser() {
		when(userRepository.findByEmail(userIvy.getEmail())).thenReturn(userIvy);
		assertThat(userIvy).isEqualTo(userServiceImpl.findByEmail(userIvy.getEmail()));
	}

	@Test
	public void findByUserName_givenUsernameDoesntExist_returnsNull() {
		when(userRepository.findByEmail(userIvy.getEmail())).thenReturn(null);
		assertThat(userServiceImpl.findByEmail(userIvy.getEmail())).isNull();
	}

	@Test
	public void loadUserByUsername_givenUsernameDoesExist_returnsUserDetailsImpl() {
		when(userServiceImpl.findByEmail(userIvy.getEmail())).thenReturn(userIvy);

		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) userServiceImpl.loadUserByUsername(userIvy.getEmail());
		assertThat(userIvy).isEqualTo(userDetailsImpl.getUser());
	}

	@Test(expected = UsernameNotFoundException.class)
	public void loadUserByUsername_givenUsernameDoesNotExist_throwsUsernameNotFoundException() {
		when(userServiceImpl.findByEmail(userIvy.getEmail())).thenReturn(null);

		userServiceImpl.loadUserByUsername(userIvy.getEmail());
	}
	
	@Test
	public void deleteUserByUsername_givenUsername_deletesUser() throws Exception {
		String username = userIvy.getEmail();
		when(userRepository.findByEmail(username)).thenReturn(null);
		
		User user = userServiceImpl.findByEmail(username);
		
		verify(userRepository, times(1)).findByEmail(username);
		verifyNoMoreInteractions(userRepository);
		assertThat(user).isNull();
	}
}
