package ch.ilge.ivy.webContext.domain.menu;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;

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

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@ContextConfiguration(classes = IvyTestApplication.class)
@DataJpaTest 
public class MenuRepositoryTest {
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private TestEntityManager entityManager;
	
	private Menu menuNormal;
	private Menu menuNoPork;
	private Menu menuVegi;
	
	
	@Before
	public void setup() {
		menuNormal = new Menu("Pizza Prosciutto", 0, "Leckere Pizza.");
		menuNoPork = new Menu("Pizza Margherita", 1, "Feine Pizza.");
		menuVegi = new Menu("Vegetarische Pizza", 2, "Mit Paprika und Pilze.");
		entityManager.persist(menuNormal);
		entityManager.persist(menuNoPork);
		entityManager.persist(menuVegi);
	}
	
	@Test
	public void getRandomMenus_givenTypeNormal_returnsRandomMenuNormal() {
		ArrayList<Menu> menus = new ArrayList<>( menuRepository.getRandomMenus(0, 1));
		
		assertThat(menus.get(0)).isEqualTo(menuNormal);
	}
	
	@Test
	public void getRandomMenus_givenTypeNoPork_returnsRandomMenuNoPork() {
		ArrayList<Menu> menus = new ArrayList<>( menuRepository.getRandomMenus(1, 1));
		
		assertThat(menus.get(0)).isEqualTo(menuNoPork);
	}
	
	@Test
	public void getRandomMenus_givenTypeVegi_returnsRandomMenuVegi() {
		ArrayList<Menu> menus = new ArrayList<>( menuRepository.getRandomMenus(2, 1));
		
		assertThat(menus.get(0)).isEqualTo(menuVegi);
	}
	
	@Test
	public void getRandomMenus_givenCountThree_returnsThreeRandomMenu() {
		ArrayList<Menu> menus = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			menus.addAll(menuRepository.getRandomMenus(i, 3));
		}
		
		assertThat(menus.size()).isEqualTo(3);
	}
	
}
