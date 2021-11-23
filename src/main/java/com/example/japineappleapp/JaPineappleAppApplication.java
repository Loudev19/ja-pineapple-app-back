package com.example.japineappleapp;

import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.japineappleapp.models.Category;
import com.example.japineappleapp.models.ECategory;
import com.example.japineappleapp.models.ERole;
import com.example.japineappleapp.models.Product;
import com.example.japineappleapp.models.Role;
import com.example.japineappleapp.models.User;
import com.example.japineappleapp.repositories.CategoryRepository;
import com.example.japineappleapp.repositories.ProductRepository;
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
		private CategoryRepository categoryRepository;

		@Autowired
		private ProductRepository productRepository;

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

			Category beverageCategory = new Category();
			beverageCategory.setName("Bebida");
			categoryRepository.save(beverageCategory);

			Category meatCategory = new Category();
			meatCategory.setName("Carnes");
			categoryRepository.save(meatCategory);

			Category bakeryCategory = new Category();
			bakeryCategory.setName("Pasteleria");
			categoryRepository.save(bakeryCategory);

			Category produceCategory = new Category();
			produceCategory.setName("Vegetales y frutas");
			categoryRepository.save(produceCategory);

			Category personalCareCategory = new Category();
			personalCareCategory.setName("Cuidado Personal");
			categoryRepository.save(personalCareCategory);

			Category noneCategory = new Category();
			noneCategory.setName("Ninguno");
			categoryRepository.save(noneCategory);

			Product cocaProduct = new Product(
				"Coc Cola", 
				"Bebida", 
				"Bebida gaseosa", 
				10, 
				5.5f
			);
			productRepository.save(cocaProduct);
			
			Set<Role> roles = new HashSet<Role>();
			roles.add(adminRole);

			User _user = new User(); 
			_user.setName("John");
            _user.setSurname("Smith");
            _user.setEmail("john@gmail.com");
            _user.setUsername("john");
            _user.setPassword(encoder.encode("123456"));
            _user.setRoles(roles);

			userRepository.save(_user);
		}
	}

}
