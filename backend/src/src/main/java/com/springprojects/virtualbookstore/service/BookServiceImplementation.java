package com.springprojects.virtualbookstore.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.repo.BookRepo;
import com.springprojects.virtualbookstore.request.CreateBookRequest;

@Service
public class BookServiceImplementation implements BookService {
	private BookRepo bookRepo;
	
	public BookServiceImplementation(BookRepo bookRepo) {
		super();
		this.bookRepo = bookRepo;
	}

	@Override
	public Book createBook(CreateBookRequest req) {
		Book book = new Book();
		book.setTitle(req.getTitle());
		book.setQuantity(req.getQuantity());
		book.setPrice(req.getPrice());
		book.setImageUrl(req.getImageUrl());
		book.setAuthorName(req.getAuthorName());
		book.setDiscountPercent(req.getDiscountPercent());
		book.setDiscountedPrice(req.getDiscountedPrice());
		book.setDescription(req.getDescription());
		book.setCreatedAt(LocalDateTime.now());
		
		return bookRepo.save(book);
	}

	@Override
	public String deleteBook(Long bookId) throws BookException {
		Book book = findBookById(bookId);
		if(book==null) throw new BookException("Book is not found with id - "+bookId);
		bookRepo.delete(book);
		return "Book is deleted successfully";
	}

	@Override
	public Book updateBook(Long bookId, Book req) throws BookException {
		Book book = findBookById(bookId);
		if(book==null) throw new BookException("Book is not found with id - "+bookId);
		
		if(req.getQuantity()!=0) {
			book.setQuantity(req.getQuantity());
		}
		return bookRepo.save(book);
	}

	@Override
	public Book findBookById(Long bookId) throws BookException {
		System.out.println("BookRepo : "+bookRepo.count());
		for(Book book:getAllBooks()) {
			System.out.println(book.getTitle()+ " " + book.getId());
		}
		Optional<Book> opt = bookRepo.findById(bookId);
		
		if(opt.isPresent()) return opt.get();
		throw new BookException("Book is not found with id - "+bookId);
	}

	@Override
	public List<Book> getAllBooks() {
		return bookRepo.findAll();
	}
	
}
