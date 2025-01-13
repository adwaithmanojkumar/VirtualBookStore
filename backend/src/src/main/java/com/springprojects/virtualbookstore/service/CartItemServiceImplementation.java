package com.springprojects.virtualbookstore.service;

import java.util.Optional;
import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.CartItemException;
import com.springprojects.virtualbookstore.exception.UserException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.CartItem;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.CartItemRepo;

@Service
public class CartItemServiceImplementation implements CartItemService {
	private CartItemRepo cartItemRepo;
	private UserService userService;
	
	public CartItemServiceImplementation(CartItemRepo cartItemRepo, UserService userService) {
		super();
		this.cartItemRepo = cartItemRepo;
		this.userService = userService;
	}

	@Override
	public CartItem createCartItem(CartItem cartItem) {
		cartItem.setQuantity(1);
		cartItem.setPrice(cartItem.getBook().getPrice()*cartItem.getQuantity());
		cartItem.setDiscountedPrice(cartItem.getBook().getDiscountedPrice()*cartItem.getQuantity());
		
		CartItem createdCartItem = cartItemRepo.save(cartItem);
		return createdCartItem;
	}

	@Override
	public CartItem updateCartItem(Long userId, Long cartItemId, CartItem cartItem)
			throws CartItemException, UserException {
		CartItem item = findCartItemById(cartItemId);
		User user = userService.findUserById(userId);
		
		if(user.getId().equals(userId)) {
			item.setQuantity(item.getQuantity());
			item.setPrice(item.getBook().getPrice()*item.getQuantity());
			item.setDiscountedPrice(item.getBook().getDiscountedPrice()*item.getQuantity());
		}
		
		return cartItemRepo.save(item);
	}
	
	@Override
	public CartItem isCartItemExist(Book book, Cart cart, Long userId) {
		CartItem cartItem = cartItemRepo.isCartItemExist(cart, book, userId);
		return cartItem;
	}

	@Override
	public void removeCartItem(Long userId, Long cartItemId) throws CartItemException, UserException {
		CartItem cartItem = findCartItemById(cartItemId);
		User user = userService.findUserById(cartItem.getUserId());
		User reqUser = userService.findUserById(userId);
		
		if(user.getId().equals(reqUser.getId())) cartItemRepo.delete(cartItem);
		else throw new UserException("You can't remove another users items");
	}

	@Override
	public CartItem findCartItemById(Long cartItemId) throws CartItemException {
		Optional<CartItem> opt = cartItemRepo.findById(cartItemId);

		if (opt.isPresent())
			return opt.get();
		throw new CartItemException("CartItem is not found with id " + cartItemId);
	}

}
