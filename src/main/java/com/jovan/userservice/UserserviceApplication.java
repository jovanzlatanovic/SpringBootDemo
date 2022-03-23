package com.jovan.userservice;

import com.jovan.userservice.model.Role;
import com.jovan.userservice.model.User;
import com.jovan.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	CommandLineRunner run(UserService userService) {
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));

			userService.saveUser(new User(null, "Steve Stephen", "stephe", "1234", new ArrayList<>()));
			userService.saveUser(new User(null, "John Johnson", "jayjay", "3456", new ArrayList<>()));
			userService.saveUser(new User(null, "Brad Bam", "baybay", "4567", new ArrayList<>()));

			userService.addRoleToUser("stephe", "ROLE_USER");
			userService.addRoleToUser("jayjay", "ROLE_USER");
			userService.addRoleToUser("baybay", "ROLE_ADMIN");
		};
	}
}
