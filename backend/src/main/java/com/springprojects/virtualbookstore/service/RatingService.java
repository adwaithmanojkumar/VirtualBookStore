package com.springprojects.virtualbookstore.service;

import java.util.List;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Rating;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.RatingRequest;

public interface RatingService {
	public Rating createRating(RatingRequest req,User user) throws BookException;
	
	public List<Rating> getBooksRating(Long bookId);
}
