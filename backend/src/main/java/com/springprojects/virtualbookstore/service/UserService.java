package com.springprojects.virtualbookstore.service;

import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.User;

public interface UserService {
	public User findUserById(Long id) throws UserException;

	public User findUserProfileByJwt(String jwt) throws UserException;
}
