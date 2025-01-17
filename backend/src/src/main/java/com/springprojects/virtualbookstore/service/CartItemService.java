package com.springprojects.virtualbookstore.service;

import com.springprojects.virtualbookstore.exception.CartItemException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.CartItem;

public interface CartItemService {
	public CartItem createCartItem(CartItem cartItem);

	public CartItem updateCartItem(Long userId, Long cartItemId, CartItem cartItem)
			throws CartItemException, UserException;

	public CartItem isCartItemExist(Book book, Cart cart, Long userId);

	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException;

	public CartItem findCartItemById(Long cartItemId) throws CartItemException;
}
