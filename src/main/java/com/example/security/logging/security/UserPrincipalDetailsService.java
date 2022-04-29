package com.example.security.logging.security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.security.logging.model.User;
import com.example.security.logging.repository.UserRepository;

@Service
public class UserPrincipalDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	
	public UserPrincipalDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user = userRepository.findByUsername(username);
		return new UserPrincipal(user);
	}

	
}
