package com.springprojects.virtualbookstore.request;

public class RatingRequest {
	private Long bookId;
	private double rating;

	public RatingRequest() {
		// TODO Auto-generated constructor stub
	}

	public RatingRequest(Long bookId, double rating) {
		super();
		this.bookId = bookId;
		this.rating = rating;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public double getRating() {
		return rating;
	}

	public void setRating(double rating) {
		this.rating = rating;
	}
}
