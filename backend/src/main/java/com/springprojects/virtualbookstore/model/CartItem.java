package com.springprojects.virtualbookstore.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class CartItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@JsonIgnore
	@ManyToOne
	private Cart cart;
	
	@ManyToOne
	@JoinColumn(name = "book_id",nullable = false)
	private Book book;
	
	private int quantity;
	
	private int price;
	
	@Column(name = "discounted_price")
	private int discountedPrice;
	
	private Long userId;
	
	public CartItem() {
		// TODO Auto-generated constructor stub
	}

	public CartItem(Long id, Cart cart, Book book, int quantity, int price,
			int discountedPrice, Long userId) {
		super();
		this.id = id;
		this.cart = cart;
		this.book = book;
		this.quantity = quantity;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
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
}
