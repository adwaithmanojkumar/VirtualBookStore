package com.springprojects.virtualbookstore.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Rating;
import com.springprojects.virtualbookstore.model.Review;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.RatingRepo;
import com.springprojects.virtualbookstore.repo.ReviewRepo;
import com.springprojects.virtualbookstore.request.ReviewRequest;

@Service
public class ReviewServiceImplementation implements ReviewService {
	private BookService bookService;
	private ReviewRepo reviewRepo;
	
	public ReviewServiceImplementation(ReviewRepo reviewRepo, BookService bookService) {
		super();
		this.reviewRepo = reviewRepo;
		this.bookService = bookService;
	}

	@Override
	public Review createReview(ReviewRequest req, User user) throws BookException {
		Book book = bookService.findBookById(req.getBookId());

		if (book == null)
			throw new BookException("Book is not found with rquested book id - " + req.getBookId());

		Review review = new Review();
		review.setBook(book);
		review.setReview(req.getReview());
		review.setUser(user);
		review.setCreatedAt(LocalDateTime.now());
		return reviewRepo.save(review);
	}

	@Override
	public List<Review> getBooksReview(Long bookId) {
		return reviewRepo.getAllBooksReview(bookId);
	}
}
