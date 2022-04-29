package com.example.security.logging.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.security.logging.model.User;
import com.example.security.logging.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {

	private UserService userService;
	
	private static final Logger log = LoggerFactory.getLogger(UserController.class);
	
	
	public UserController(UserService userService) {
		super();
		this.userService = userService;
		
	}

	// build create user REST API
	@PostMapping()
	public ResponseEntity<User> saveUser(@RequestBody User user){
		/*
		 * User u = new User();
		 * u.setUsername(user.getUsername());
		u.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
		u.setNomeCognome(u.getNomeCognome());
		 */
		log.info("Creating new user {}", user.getNomeCognome());
		return new ResponseEntity<User>(userService.saveUser(user), HttpStatus.CREATED);
	}

	// build get all users REST API
	@GetMapping
	public ResponseEntity<List<User>> getAllUsers(){
		log.info("Retrieve information about all users");
		return new ResponseEntity<List<User>>(userService.getAllUsers(), HttpStatus.OK);
	}

	// build get user by id REST API
	// http://localhost:8080/users/1
	@GetMapping("{id}")
	public ResponseEntity<User> getUserById(@PathVariable("id") int userId){
		return new ResponseEntity<User>(userService.getUserById(userId), HttpStatus.OK);
	}
	
	
	
}
