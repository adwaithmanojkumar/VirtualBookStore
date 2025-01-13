package com.springprojects.virtualbookstore.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.config.JwtProvider;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.UserServiceRepo;

@Service
public class UserServiceImplementation implements UserService {
	private UserServiceRepo userServiceRepo;
	private JwtProvider jwtProvider;
	
	public UserServiceImplementation(UserServiceRepo userServiceRepo, JwtProvider jwtProvider) {
		super();
		this.userServiceRepo = userServiceRepo;
		this.jwtProvider = jwtProvider;
	}

	@Override
	public User findUserById(Long id) throws UserException {
		Optional<User> opt = userServiceRepo.findById(id);
		
		if(opt.isPresent()) {
			return opt.get();
		}
		throw new UserException("User is not found with id "+id);
	}

	@Override
	public User findUserProfileByJwt(String jwt) throws UserException {
		String email = jwtProvider.getEmailForToken(jwt);
		User user = userServiceRepo.findByEmail(email);
		
		if(user==null) throw new UserException("User is not found with email "+email);
		
		return user;
	}
	
	@Override
	public User findUserProfileByEmail(String email) throws UserException {
		User user = userServiceRepo.findByEmail(email);

		if (user == null)
			throw new UserException("User is not found with email " + email);

		return user;
	}
}
