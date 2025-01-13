package com.springprojects.virtualbookstore.request;

public class AddItemRequest {
	private Long bookId;
	private int quantity;

	public AddItemRequest() {
		// TODO Auto-generated constructor stub
	}

	public AddItemRequest(Long bookId, int quantity) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
