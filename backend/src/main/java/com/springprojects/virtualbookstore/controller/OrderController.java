package com.springprojects.virtualbookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.OrderException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Address;
import com.springprojects.virtualbookstore.model.Order;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.service.OrderService;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/orders")
public class OrderController {
	private OrderService orderService;
	private UserService userService;
	
	public OrderController(OrderService orderService, UserService userService) {
		super();
		this.orderService = orderService;
		this.userService = userService;
	}
	
	@PostMapping("/")
	public ResponseEntity<Order> createOrder(@RequestBody Address shippingAddress,@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		Order order = orderService.createOrder(user, shippingAddress);
		return new ResponseEntity<Order>(order, HttpStatus.CREATED);
	}
	
	@GetMapping("/user")
	public ResponseEntity<List<Order>> usersOrderHistory(@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		List<Order> orders = orderService.usersOrderHistory(user.getId());
		return new ResponseEntity<List<Order>>(orders, HttpStatus.CREATED);
	}
	
	@GetMapping("/{orderId}")
	public ResponseEntity<Order> findOrderById(@PathVariable("orderId") Long orderId,@RequestHeader("Authorization") String jwt) throws UserException, OrderException {
		User user = userService.findUserProfileByJwt(jwt);
		Order order = orderService.findOrderById(orderId);
		return new ResponseEntity<Order>(order, HttpStatus.ACCEPTED);
	}
}
