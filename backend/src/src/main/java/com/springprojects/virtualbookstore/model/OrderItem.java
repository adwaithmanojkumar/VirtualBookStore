package com.springprojects.virtualbookstore.model;

import java.time.LocalDateTime;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class OrderItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@JsonIgnore
	@ManyToOne
	private Order order;

	@ManyToOne
	private Book book;

	private int price;

	private int quantity;
	
	@Column(name = "discounted_price")
	private int discountedPrice;

	private Long userId;

	@Column(name = "delivery_date")
	private LocalDateTime deliveryDate;

	public OrderItem() {
		// TODO Auto-generated constructor stub
	}

	public OrderItem(Long id, Order order, Book book, int price, int quantity, int discountedPrice, Long userId,
			LocalDateTime deliveryDate) {
		super();
		this.id = id;
		this.order = order;
		this.book = book;
		this.price = price;
		this.quantity = quantity;
		this.discountedPrice = discountedPrice;
		this.userId = userId;
		this.deliveryDate = deliveryDate;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getDiscountedPrice() {
		return discountedPrice;
	}

	public void setDiscountedPrice(int discountedPrice) {
		this.discountedPrice = discountedPrice;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public LocalDateTime getDeliveryDate() {
		return deliveryDate;
	}

	public void setDeliveryDate(LocalDateTime deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
}
