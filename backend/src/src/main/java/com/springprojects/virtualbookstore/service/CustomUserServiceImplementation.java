package com.springprojects.virtualbookstore.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.UserServiceRepo;

@Service
public class CustomUserServiceImplementation implements UserDetailsService {
	private UserServiceRepo userServiceRepo;
	
	public CustomUserServiceImplementation(UserServiceRepo userServiceRepo) {
		super();
		this.userServiceRepo = userServiceRepo;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userServiceRepo.findByEmail(username);
		if(user==null) {
			throw new UsernameNotFoundException("User is not found with email - "+username);
		}
		
		List<GrantedAuthority> authorities = new ArrayList<>();
		return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), authorities);
	}
	
}
