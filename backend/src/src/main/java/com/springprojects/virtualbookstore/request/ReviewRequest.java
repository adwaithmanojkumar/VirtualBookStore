package com.springprojects.virtualbookstore.request;

public class ReviewRequest {
	private Long bookId;
	private String review;
	
	public ReviewRequest() {
		// TODO Auto-generated constructor stub
	}

	public ReviewRequest(Long bookId, String review) {
		super();
		this.bookId = bookId;
		this.review = review;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}
}
