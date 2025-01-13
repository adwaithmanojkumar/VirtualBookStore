package com.springprojects.virtualbookstore.service;

import java.util.List;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.request.CreateBookRequest;

public interface BookService {
	public Book createBook(CreateBookRequest req);
	
	public String deleteBook(Long bookId) throws BookException;
	
	public Book updateBook(Long bookId,Book req) throws BookException;
	
	public Book findBookById(Long bookId) throws BookException;
	
	public List<Book> getAllBooks();
}
