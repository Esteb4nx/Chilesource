package com.chilesource.Forowebspring;

import com.chilesource.Forowebspring.model.User;
import com.chilesource.Forowebspring.repository.UserRepository;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class ForowebSpringApplicationTests {

	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Test
	@Disabled
	public void newUserTest() {
		User user = new User();
		user.setUserName("user");
		user.setEmail("user@dummy.cl");
		user.setPassword(encoder.encode("123"));
		User saved = repo.save(user);
		assertTrue(saved.getPassword().equalsIgnoreCase(user.getPassword()));
	}

}
