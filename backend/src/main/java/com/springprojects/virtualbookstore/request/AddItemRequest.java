package com.springprojects.virtualbookstore.request;

public class AddItemRequest {
	private Long bookId;
	private int quantity;
	private int price;

	public AddItemRequest() {
		// TODO Auto-generated constructor stub
	}

	public AddItemRequest(Long bookId, int quantity, int price) {
		super();
		this.bookId = bookId;
		this.quantity = quantity;
		this.price = price;
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

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
