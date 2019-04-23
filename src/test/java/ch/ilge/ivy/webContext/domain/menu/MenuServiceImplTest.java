package ch.ilge.ivy.webContext.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;

/**
 * This is the JUnit-Test for the ServiceImpl Menu.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class MenuServiceImplTest extends ExtendedServiceImplTest<MenuServiceImpl, Menu, MenuRepository> {
	 
	@InjectMocks
	private MenuServiceImpl menuServiceImpl;
	
	@Mock
	private MenuRepository menuRepository;
	
	private Menu menuNormal;
	private Menu menuNoPork;
	private Set<Menu> menus;

	@Before
	public void setup() {
		// Setup menus
		menuNormal = new Menu(1L, "Pizza Prosciutto", 0, "Leckere Pizza.");
		menuNoPork = new Menu(2L, "Pizza Margherita", 1, "Feine Pizza.");
		
		menus = new HashSet<>();
		menus.add(menuNormal);
		
		super.setup(menuServiceImpl,  menuRepository,  menuNormal,  menuNoPork);
	}
	
	@Test
	public void getRandomMenuse_givenType_returnsWantedTypeOfMenu() {
		when(menuRepository.getRandomMenus(0, 1)).thenReturn(menus);
		
		assertThat(menus).isEqualTo(menuRepository.getRandomMenus(0,1));
	}
	
	@Test
	public void getRandomMenuse_givenTypeDoesNotExist_returnsNull() {
		when(menuRepository.getRandomMenus(1, 1)).thenReturn(null);
		
		assertThat(menuRepository.getRandomMenus(1,1)).isNull();
	}
	
}
