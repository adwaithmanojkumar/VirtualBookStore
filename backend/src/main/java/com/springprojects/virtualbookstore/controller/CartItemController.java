package com.springprojects.virtualbookstore.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springprojects.virtualbookstore.exception.CartItemException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.CartItem;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.response.ApiResponse;
import com.springprojects.virtualbookstore.service.CartItemService;
import com.springprojects.virtualbookstore.service.UserService;

@RestController
@RequestMapping("/cartItem")
public class CartItemController {
	private UserService userService;
	private CartItemService cartItemService;
	
	public CartItemController(UserService userService, CartItemService cartItemService) {
		super();
		this.userService = userService;
		this.cartItemService = cartItemService;
	}
	
	@DeleteMapping("/{cartItemId}")
	public ResponseEntity<ApiResponse> deleteCartItem(@PathVariable Long cartItemId,@RequestHeader("Authorization") String jwt) throws UserException, CartItemException {
		User user = userService.findUserProfileByJwt(jwt);
		cartItemService.removeCartItem(user.getId(), cartItemId);
		
		ApiResponse response = new ApiResponse();
		response.setMessage("CartItem is deleted successfully");
		response.setStatus(true);
		
		return new ResponseEntity<ApiResponse>(response, HttpStatus.OK);
	}
	
	@PutMapping("/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long cartItemId,@RequestHeader("Authorization") String jwt,@RequestBody CartItem cartItem) throws UserException, CartItemException {
		User user = userService.findUserProfileByJwt(jwt);
		CartItem updatedCartItem = cartItemService.updateCartItem(user.getId(), cartItemId, cartItem);
		
		return new ResponseEntity<CartItem>(updatedCartItem, HttpStatus.OK);
	}
}
