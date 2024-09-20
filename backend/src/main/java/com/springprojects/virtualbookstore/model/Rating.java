package com.springprojects.virtualbookstore.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "user_id",nullable = false)
	private User user;
	
	@ManyToOne
	@JoinColumn(name = "book_id",nullable = false,insertable = false,updatable = false)
	private Book book;
	
	@Column(name = "rating")
	private double rating;
	
	private LocalDateTime createdAt;
	
	@Column(name = "book_id",nullable = false)
	private Long bookId;
	
	public Rating() {
		// TODO Auto-generated constructor stub
	}

	public Rating(Long id, User user, Book book, double rating, LocalDateTime createdAt, Long bookId) {
		super();
		this.id = id;
		this.user = user;
		this.book = book;
		this.rating = rating;
		this.createdAt = createdAt;
		this.bookId = bookId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}

	public LocalDateTime getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDateTime createdAt) {
		this.createdAt = createdAt;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}
}
