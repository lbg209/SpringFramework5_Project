package mylab.user.di.annot;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(locations = "classpath:mylab-user-di.xml")
public class UserServiceTest {

	@Autowired
	UserService userService;
	
	@Test
	void userServiceTest() {

		assertNotNull(userService);
		assertNotNull(userService.getUserRepository());
		assertNotNull(userService.getSecurityService());
		assertEquals("MySQL", userService.getUserRepository().getDbType());
		assertTrue(userService.registerUser("1001", "LEE", "1234"));
		assertFalse(userService.registerUser("1002", "KIM", null));
	}
}
