package com.springprojects.virtualbookstore.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Rating;
import com.springprojects.virtualbookstore.model.Review;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.RatingRequest;
import com.springprojects.virtualbookstore.request.ReviewRequest;
import com.springprojects.virtualbookstore.service.ReviewService;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
	private ReviewService reviewService;
	private UserService userService;
	
	public ReviewController(ReviewService reviewService, UserService userService) {
		super();
		this.reviewService = reviewService;
		this.userService = userService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Review> createRating(@RequestBody ReviewRequest req,@RequestHeader("Authorization") String jwt) throws BookException, UserException {
		User user = userService.findUserProfileByJwt(jwt);
		Review review = reviewService.createReview(req, user);
		return new ResponseEntity<Review>(review, HttpStatus.CREATED);
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<List<Review>> getBooksReview(@PathVariable Long bookId) {
		List<Review> reviews = reviewService.getBooksReview(bookId);
		return new ResponseEntity<List<Review>>(reviews, HttpStatus.ACCEPTED);
	}
}
