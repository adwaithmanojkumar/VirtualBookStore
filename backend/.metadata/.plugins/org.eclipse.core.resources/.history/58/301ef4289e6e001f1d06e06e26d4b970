package com.springprojects.virtualbookstore.service;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.request.AddItemRequest;

public interface CartService {
	public Cart createCart(User user);

	public String addCartItem(Long userId, AddItemRequest req) throws BookException;

	public Cart findUserCart(Long userId);
}
