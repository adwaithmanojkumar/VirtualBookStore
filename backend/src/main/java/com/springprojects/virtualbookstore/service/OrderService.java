package com.springprojects.virtualbookstore.service;

import java.util.List;

import com.springprojects.virtualbookstore.exception.OrderException;
import com.springprojects.virtualbookstore.model.Address;
import com.springprojects.virtualbookstore.model.Order;
import com.springprojects.virtualbookstore.model.User;

public interface OrderService {
	public Order createOrder(User user,Address shippingAddress);
	
	public Order findOrderById(Long orderId) throws OrderException; 
	
	public List<Order> usersOrderHistory(Long userId);
	
	public Order placedOrder(Long orderId) throws OrderException;
	
	public Order confirmedOrder(Long orderId) throws OrderException;
	
	public Order shippedOrder(Long orderId) throws OrderException;
	
	public Order deliveredOrder(Long orderId) throws OrderException;
	
	public Order cancelledOrder(Long orderId) throws OrderException;
	
	public List<Order> getAllOrders();
	
	public void deleteOrder(Long orderId) throws OrderException;
}
