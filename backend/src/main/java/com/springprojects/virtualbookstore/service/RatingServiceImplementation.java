package com.springprojects.virtualbookstore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Rating;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.RatingRepo;
import com.springprojects.virtualbookstore.request.RatingRequest;

@Service
public class RatingServiceImplementation implements RatingService {
	private RatingRepo ratingRepo;
	private BookService bookService;
	
	public RatingServiceImplementation(RatingRepo ratingRepo, BookService bookService) {
		super();
		this.ratingRepo = ratingRepo;
		this.bookService = bookService;
	}

	@Override
	public Rating createRating(RatingRequest req, User user) throws BookException {
		Book book = bookService.findBookById(req.getBookId());
		
		if(book==null) throw new BookException("Book is not found with rquested book id - "+req.getBookId());
		
		Rating rating = new Rating();
		rating.setBook(book);
		rating.setRating(req.getRating());
		rating.setUser(user);
		rating.setCreatedAt(LocalDateTime.now());
		return ratingRepo.save(rating);
	}

	@Override
	public List<Rating> getBooksRating(Long bookId) {
		return ratingRepo.getAllBooksRating(bookId);
	}

}
