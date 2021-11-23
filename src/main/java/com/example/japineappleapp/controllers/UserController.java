package com.example.japineappleapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.japineappleapp.models.ERole;
import com.example.japineappleapp.models.Role;
import com.example.japineappleapp.models.User;
import com.example.japineappleapp.payload.request.SignupRequest;
import com.example.japineappleapp.services.UserService;
import com.example.japineappleapp.services.RoleService;

import java.util.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class UserController {
	@Autowired
    private UserService userService;

    @Autowired
    RoleService roleService;

	@GetMapping("/forgot_password/{email}")
    public ResponseEntity<User> forgotPassword(@PathVariable(value="email") String email) {
		Optional<User> user = userService.findByEmail(email);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
	
	@GetMapping("/users")
    public ResponseEntity<List<User>> listaUsers() {
    	try {
            List<User> users = new ArrayList<User>();
            userService.findAll().forEach(users::add);
            if(users.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(users, HttpStatus.OK);
        } catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> consultaUser(@PathVariable(value="id") Integer id) {
    	Optional<User> user = userService.findById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> actualizaUser(@PathVariable("id") Integer id, @RequestBody SignupRequest user) {
    	Optional<User> userData = userService.findById(id);

        if(userData.isPresent()) {
            User _user = userData.get();
            _user.setName(user.getName());
            _user.setSurname(user.getSurname());
            _user.setEmail(user.getEmail());
            _user.setUsername(user.getUsername());
            _user.setPassword(user.getPassword());

            Set<String> strRoles = user.getRole();
            Set<Role> roles = new HashSet<>();
    
            System.out.println(strRoles);
    
            if (strRoles == null) {
                Role userRole = roleService.findByName(ERole.ROLE_USER)
                        .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
                roles.add(userRole);
            } else {
                strRoles.forEach(role -> {
                    switch (role) {
                        case "admin":
                            Role adminRole = roleService.findByName(ERole.ROLE_ADMIN)
                                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
                            roles.add(adminRole);
    
                            break;
                        default:
                            Role userRole = roleService.findByName(ERole.ROLE_USER)
                                    .orElseThrow(() -> new RuntimeException("Error: No se encuentra dicho Rol."));
                            roles.add(userRole);
                    }
                });
            }
    
            _user.setRoles(roles);

            return new ResponseEntity<User>(userService.save(_user), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<HttpStatus> eliminaUser(@PathVariable(value="id") Integer id) {
    	try {
            userService.delete(id);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
