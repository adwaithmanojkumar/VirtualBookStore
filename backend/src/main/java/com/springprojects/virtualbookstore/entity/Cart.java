package com.springprojects.virtualbookstore.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "MyCart")
public class Cart {
	private String userName;
	@Id
	@GeneratedValue()
	@NotNull
	private int id;
	private String bookName;
	private String authorName;
	private LocalDate publishedDate;

	public Cart() {
	}

	/**
	 * @param id
	 * @param bookName
	 * @param authorName
	 * @param publishedDate
	 */
	public Cart(int id, String bookName, String authorName, LocalDate publishedDate) {
		super();
		this.id = id;
		this.bookName = bookName;
		this.authorName = authorName;
		this.publishedDate = publishedDate;
	}

	/**
	 * @return userName;
	 */
	public String getUserName() {
		return userName;
	}

	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}

	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * @return the bookName
	 */
	public String getBookName() {
		return bookName;
	}

	/**
	 * @param bookName the bookName to set
	 */
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	/**
	 * @return the authorName
	 */
	public String getAuthorName() {
		return authorName;
	}

	/**
	 * @param authorName the authorName to set
	 */
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}

	/**
	 * @return the publishedDate
	 */
	public LocalDate getPublishedDate() {
		return publishedDate;
	}

	/**
	 * @param publishedDate the publishedDate to set
	 */
	public void setPublishedDate(LocalDate publishedDate) {
		this.publishedDate = publishedDate;
	}

}
