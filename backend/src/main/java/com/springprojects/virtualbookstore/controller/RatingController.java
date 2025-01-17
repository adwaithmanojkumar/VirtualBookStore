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
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.RatingRequest;
import com.springprojects.virtualbookstore.service.RatingService;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/ratings")
public class RatingController {
	private UserService userService;
	private RatingService ratingService;
	
	public RatingController(UserService userService, RatingService ratingService) {
		super();
		this.userService = userService;
		this.ratingService = ratingService;
	}
	
	@PostMapping("/create")
	public ResponseEntity<Rating> createRating(@RequestBody RatingRequest req,@RequestHeader("Authorization") String jwt) throws BookException, UserException {
		User user = userService.findUserProfileByJwt(jwt);
		Rating rating = ratingService.createRating(req, user);
		return new ResponseEntity<Rating>(rating, HttpStatus.CREATED);
	}
	
	@GetMapping("/books/{bookId}")
	public ResponseEntity<List<Rating>> getBooksRating(@PathVariable Long bookId) {
		List<Rating> ratings = ratingService.getBooksRating(bookId);
		return new ResponseEntity<List<Rating>>(ratings, HttpStatus.ACCEPTED);
	}
}
