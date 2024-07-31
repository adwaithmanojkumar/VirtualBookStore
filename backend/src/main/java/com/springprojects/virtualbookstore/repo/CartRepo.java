package com.springprojects.virtualbookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.virtualbookstore.entity.Cart;

public interface CartRepo extends JpaRepository<Cart, Integer> {
	List<Cart> findByUserName(String userName);
}
