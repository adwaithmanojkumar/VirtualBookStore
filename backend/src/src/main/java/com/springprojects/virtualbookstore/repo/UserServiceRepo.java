package com.springprojects.virtualbookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.User;

@Repository
public interface UserServiceRepo extends JpaRepository<User, Long>{
	public User findByEmail(String email);
}
