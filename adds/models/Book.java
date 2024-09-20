package com.springprojects.virtualbookstore.model;

import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Book {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private String title;
	
	private String authorName;
	
	private int price;
	
	@Column(name = "discounted_price")
	private int discountedPrice;
	
	@Column(name = "discount_percent")
	private int discountPercent;
	
	private String description;
	
	private int quantity;
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Rating> ratings = new ArrayList<>();
	
	@OneToMany(mappedBy = "book",cascade = CascadeType.ALL,orphanRemoval = true)
	private List<Review> reviews = new ArrayList<>();
	
	@Column(name = "image_url")
	private String imageUrl;
	
	public Book() {
		// TODO Auto-generated constructor stub
	}

	public Book(Long id, String title, String authorName, int price, int discountedPrice, int discountPercent,
			String description, int quantity, List<Rating> ratings, List<Review> reviews, String imageUrl) {
		super();
		this.id = id;
		this.title = title;
		this.authorName = authorName;
		this.price = price;
		this.discountedPrice = discountedPrice;
		this.discountPercent = discountPercent;
		this.description = description;
		this.quantity = quantity;
		this.ratings = ratings;
		this.reviews = reviews;
		this.imageUrl = imageUrl;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getAuthorName() {
		return authorName;
	}

	public void setAuthorName(String authorName) {
		this.authorName = authorName;
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

	public int getDiscountPercent() {
		return discountPercent;
	}

	public void setDiscountPercent(int discountPercent) {
		this.discountPercent = discountPercent;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public List<Rating> getRatings() {
		return ratings;
	}

	public void setRatings(List<Rating> ratings) {
		this.ratings = ratings;
	}

	public List<Review> getReviews() {
		return reviews;
	}

	public void setReviews(List<Review> reviews) {
		this.reviews = reviews;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
}
