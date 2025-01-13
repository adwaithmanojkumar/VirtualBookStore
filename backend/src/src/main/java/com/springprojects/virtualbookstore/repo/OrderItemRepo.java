package com.springprojects.virtualbookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.virtualbookstore.model.OrderItem;

public interface OrderItemRepo extends JpaRepository<OrderItem, Long>{
	
}
