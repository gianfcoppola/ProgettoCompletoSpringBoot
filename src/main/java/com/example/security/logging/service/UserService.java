package com.example.security.logging.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.security.logging.model.User;
import com.example.security.logging.repository.UserRepository;

@Service
public class UserService {

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	public List<User> getAllUsers(){
		return userRepository.findAll();
	}
	
	public User getUserById(int id) {
		return userRepository.findById(id).get();
	}


	public User saveUser(User user) {
		return userRepository.save(user);
	}

	
	
}
