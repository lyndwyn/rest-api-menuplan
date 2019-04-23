package ch.ilge.ivy.webContext.domain.role;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;
import ch.ilge.ivy.webContext.domain.authority.Authority;

/**
 * This is the JUnit-Test for the ServiceImpl Role.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class RoleServiceImplTest extends ExtendedServiceImplTest<RoleServiceImpl, Role, RoleRepository> {
	 
	@InjectMocks
	private  RoleServiceImpl roleServiceImpl;
	
	@Mock
	private RoleRepository roleRepository;
	
	private Role roleAdmin;
	private Role roleUser;
	
	@Before
	public void setup() {
		// Stores authorities in the database
		Authority authorityRead = new Authority("READ");
		Authority authorityWrite = new Authority("WRITE");

		Set<Authority> authorities = new HashSet<>(Arrays.asList(authorityRead, authorityWrite));

		// Stores roles in the database
		roleAdmin = new Role(1L, "Admin", authorities);
		roleUser = new Role(2L, "Employee", new HashSet<>(Arrays.asList(authorityRead)));
		
		super.setup(roleServiceImpl,  roleRepository,  roleAdmin,  roleUser);
	}
	
}
