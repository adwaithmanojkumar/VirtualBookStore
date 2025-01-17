package com.springprojects.virtualbookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.AddItemRequest;
import com.springprojects.virtualbookstore.response.ApiResponse;
import com.springprojects.virtualbookstore.service.CartService;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/cart")
public class CartController {
	private UserService userService;
	private CartService cartService;
	
	public CartController(UserService userService, CartService cartService) {
		super();
		this.userService = userService;
		this.cartService = cartService;
	}
	
	@GetMapping("/")
	public ResponseEntity<Cart> findUserCart(@RequestHeader("Authorization") String jwt) throws UserException {
		User user = userService.findUserProfileByJwt(jwt);
		System.out.println(user.getId());
		Cart cart = cartService.findUserCart(user.getId());
		
		return new ResponseEntity<Cart>(cart, HttpStatus.OK);
	}
	
	@PostMapping("/add")
	public ResponseEntity<ApiResponse> addItemsToCart(@RequestBody AddItemRequest req,@RequestHeader("Authorization") String jwt) throws UserException, BookException {
		User user = userService.findUserProfileByJwt(jwt);
		cartService.addCartItem(user.getId(), req);
		
		ApiResponse response = new ApiResponse();
		response.setStatus(true);
		response.setMessage("Added items to cart");
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
}
