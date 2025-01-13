package com.springprojects.virtualbookstore.service;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.model.OrderItem;
import com.springprojects.virtualbookstore.repo.OrderItemRepo;

@Service
public class OrderItemServiceImplementation implements OrderItemService {
	private OrderItemRepo orderItemRepo;
	
	public OrderItemServiceImplementation(OrderItemRepo orderItemRepo) {
		super();
		this.orderItemRepo = orderItemRepo;
	}

	@Override
	public OrderItem createOrderItem(OrderItem orderItem) {
		return orderItemRepo.save(orderItem);
	}

}
