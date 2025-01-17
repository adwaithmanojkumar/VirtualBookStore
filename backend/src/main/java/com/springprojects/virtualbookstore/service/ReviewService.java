package com.springprojects.virtualbookstore.service;

import java.util.List;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Review;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.ReviewRequest;

public interface ReviewService {
	public Review createReview(ReviewRequest req, User user) throws BookException;

	public List<Review> getBooksReview(Long bookId);
}
