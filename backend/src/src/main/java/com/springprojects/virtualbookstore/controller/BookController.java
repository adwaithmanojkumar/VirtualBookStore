package com.springprojects.virtualbookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.request.CreateBookRequest;
import com.springprojects.virtualbookstore.response.ApiResponse;
import com.springprojects.virtualbookstore.service.BookService;

@RestController
public class BookController {
	private BookService bookService;

	public BookController(BookService bookService) {
		super();
		this.bookService = bookService;
	}
	
	@GetMapping("/books")
	public ResponseEntity<List<Book>> getAllBooks() {
		List<Book> res = bookService.getAllBooks();
		
		return new ResponseEntity<List<Book>>(res, HttpStatus.ACCEPTED);
	}
	
	@GetMapping("/books-details/{bookId}")
	public ResponseEntity<Book> findBookById(@PathVariable Long bookId) throws BookException {
		Book res = bookService.findBookById(bookId);
		return new ResponseEntity<Book>(res, HttpStatus.ACCEPTED);
	}
	
	@PostMapping("/books/add-book")
	public ResponseEntity<Book> createBook(@RequestBody CreateBookRequest req) {
		Book res = bookService.createBook(req);
		return new ResponseEntity<Book>(res, HttpStatus.CREATED);
	}
	
	@DeleteMapping("/books/{bookId}")
	public ResponseEntity<ApiResponse> deleteBookById(@PathVariable Long bookId) throws BookException {
		String res = bookService.deleteBook(bookId);
		
		ApiResponse response = new ApiResponse();
		response.setStatus(true);
		response.setMessage(res);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
}
