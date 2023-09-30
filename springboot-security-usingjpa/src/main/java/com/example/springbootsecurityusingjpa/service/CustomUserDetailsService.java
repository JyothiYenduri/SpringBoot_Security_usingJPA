package com.example.springbootsecurityusingjpa.service;

import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.userdetails.User;
//import com.example.springbootsecurityusingjpa.entity.User;
import com.example.springbootsecurityusingjpa.repository.UserRepository;

@Service
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		User user=userRepository.findByUsername(username);
		if(user==null) {
			throw new UsernameNotFoundException("User not found with username: " +username);
		}
		return new org.springframework.security.core.userdetails.User(
	            user.getUsername(),
	            user.getPassword(),
	            Collections.emptyList()
	            
	            /* Add your user roles here if needed */
	            // Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))
	        );
	}

}
