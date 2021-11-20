package com.example.japineappleapp;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.japineappleapp.models.ERole;
import com.example.japineappleapp.models.Role;
import com.example.japineappleapp.models.User;
import com.example.japineappleapp.repositories.RoleRepository;
import com.example.japineappleapp.repositories.UserRepository;

@SpringBootApplication
public class JaPineappleAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(JaPineappleAppApplication.class, args);
	}
	
	@Component
	public class PostConstructExampleBean {

		@Autowired
		private RoleRepository roleRepository;

		@Autowired
		private UserRepository userRepository;
		
	    @Autowired
	    PasswordEncoder encoder;

		@PostConstruct
		public void init() {
			Role adminRole = new Role();
			adminRole.setName(ERole.ROLE_ADMIN);
			roleRepository.save(adminRole);

			Role userRole = new Role();
			userRole.setName(ERole.ROLE_USER);
			roleRepository.save(userRole);

			User _user = new User(); 
			_user.setName("John");
            _user.setSurname("Smith");
            _user.setEmail("john@gmail.com");
            _user.setUsername("john");
            _user.setPassword(encoder.encode("123456"));

			userRepository.save(_user);
		}
	}

}
