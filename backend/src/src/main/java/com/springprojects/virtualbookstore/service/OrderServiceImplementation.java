package com.springprojects.virtualbookstore.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.OrderException;
import com.springprojects.virtualbookstore.model.Address;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.CartItem;
import com.springprojects.virtualbookstore.model.Order;
import com.springprojects.virtualbookstore.model.OrderItem;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.AddressRepo;
import com.springprojects.virtualbookstore.repo.OrderItemRepo;
import com.springprojects.virtualbookstore.repo.OrderRepo;
import com.springprojects.virtualbookstore.repo.UserServiceRepo;
import com.springprojects.virtualbookstore.utils.OrderStatus;
import com.springprojects.virtualbookstore.utils.PaymentStatus;

@Service
public class OrderServiceImplementation implements OrderService {
	private OrderRepo orderRepo;
	private CartService cartService;
	private UserServiceRepo userServiceRepo;
	private OrderItemService orderItemService;
	private OrderItemRepo orderItemRepo;
	private AddressRepo addressRepo;
	
	public OrderServiceImplementation(OrderRepo orderRepo, CartService cartService, UserServiceRepo userServiceRepo,
			OrderItemRepo orderItemRepo, AddressRepo addressRepo,OrderItemService orderItemService) {
		super();
		this.orderRepo = orderRepo;
		this.cartService = cartService;
		this.userServiceRepo = userServiceRepo;
		this.orderItemRepo = orderItemRepo;
		this.addressRepo = addressRepo;
		this.orderItemService = orderItemService;
	}

	@Override
	public Order createOrder(User user, Address shippingAddress) {
		shippingAddress.setUser(user);
		Address address = addressRepo.save(shippingAddress);
		user.getAddress().add(address);
		userServiceRepo.save(user);

		Cart cart = cartService.findUserCart(user.getId());
		List<OrderItem> orderItems = new ArrayList<>();

		for (CartItem cartItem : cart.getCartItems()) {
			OrderItem orderItem = new OrderItem();

			orderItem.setPrice(cartItem.getPrice());
			orderItem.setBook(cartItem.getBook());
			orderItem.setDiscountedPrice(cartItem.getDiscountedPrice());
			orderItem.setQuantity(cartItem.getQuantity());
			orderItem.setUserId(cartItem.getUserId());

			OrderItem createdOrderItem = orderItemService.createOrderItem(orderItem);
			orderItems.add(createdOrderItem);
		}

		Order createdOrder = new Order();
		createdOrder.setUser(user);
		createdOrder.setOrderItems(orderItems);
		createdOrder.setTotalPrice(cart.getTotalPrice());
		createdOrder.setTotaldiscountedPrice(cart.getTotalDiscountedPrice());
		createdOrder.setDiscount(cart.getDiscount());
		createdOrder.setTotalItem(cart.getTotalItem());

		createdOrder.setShippingAddress(address);
		createdOrder.setOrderDate(LocalDateTime.now());
		createdOrder.setOrderStatus(OrderStatus.PENDING);
		createdOrder.getPaymentDetails().setPaymentStatus(PaymentStatus.PENDING);
		createdOrder.setCreatedAt(LocalDateTime.now());

		Order savedOrder = orderRepo.save(createdOrder);

		for (OrderItem item : orderItems) {
			item.setOrder(savedOrder);
			orderItemRepo.save(item);
		}

		return savedOrder;
	}

	@Override
	public Order findOrderById(Long orderId) throws OrderException {
		Optional<Order> opt = orderRepo.findById(orderId);

		if (opt.isPresent())
			return opt.get();

		throw new OrderException("Order is not found with id " + orderId);
	}

	@Override
	public List<Order> usersOrderHistory(Long userId) {
		List<Order> orders=orderRepo.getUsersOrders(userId);
		return orders;
	}

	@Override
	public Order placedOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus(OrderStatus.PLACED);
		order.getPaymentDetails().setPaymentStatus(PaymentStatus.COMPLETED);
		return orderRepo.save(order);
	}

	@Override
	public Order confirmedOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus(OrderStatus.CONFIRMED);
		return orderRepo.save(order);
	}

	@Override
	public Order shippedOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus(OrderStatus.SHIPPED);
		return orderRepo.save(order);
	}

	@Override
	public Order deliveredOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus(OrderStatus.DELIVERED);
		return orderRepo.save(order);
	}

	@Override
	public Order cancelledOrder(Long orderId) throws OrderException {
		Order order=findOrderById(orderId);
		order.setOrderStatus(OrderStatus.CANCELLED);
		return orderRepo.save(order);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderRepo.findAll();
	}

	@Override
	public void deleteOrder(Long orderId) throws OrderException {
		Order order = findOrderById(orderId);
		orderRepo.delete(order);
	}
}
