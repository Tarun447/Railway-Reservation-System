package com.cap;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootTest
class UserModuleApplicationTests {

	@Test
	void contextLoads() {
	}
	
	@Test
	void passwordEncord()
	{
		System.out.println(new BCryptPasswordEncoder().encode("admin"));
		System.out.println("------------------");
		System.out.println(new BCryptPasswordEncoder().encode("12345"));
	}

}
