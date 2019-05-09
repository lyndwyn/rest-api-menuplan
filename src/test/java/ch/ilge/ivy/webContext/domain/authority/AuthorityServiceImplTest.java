package ch.ilge.ivy.webContext.domain.authority;

import org.junit.Before;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import ch.ilge.ivy.config.generic.ExtendedServiceImplTest;
import ch.ilge.ivy.webContext.domain.authority.Authority;

/**
 * This is the JUnit-Test for the ServiceImpl Authority.
 * 
 * @author Laura Steiner
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class AuthorityServiceImplTest extends ExtendedServiceImplTest<AuthorityServiceImpl, Authority, AuthorityRepository> { 
	
	@InjectMocks
	private AuthorityServiceImpl authorityServiceImpl;
	
	@Mock
	private AuthorityRepository authorityRepository;
	
	private Authority authorityRead;
	private Authority authorityWrite;
	
	@Before
	public void setup() {
		// Setup authorities
		authorityRead = new Authority(1L, "READ");
		authorityWrite = new Authority(2L, "WRITE");
		
		super.setup(authorityServiceImpl,  authorityRepository,  authorityRead,  authorityWrite);
	}
	
}
