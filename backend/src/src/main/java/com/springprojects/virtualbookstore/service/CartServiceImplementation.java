package com.springprojects.virtualbookstore.service;

import org.springframework.stereotype.Service;

import com.springprojects.virtualbookstore.exception.BookException;
import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.CartItem;
import com.springprojects.virtualbookstore.model.User;
import com.springprojects.virtualbookstore.repo.CartRepo;
import com.springprojects.virtualbookstore.request.AddItemRequest;

@Service
public class CartServiceImplementation implements CartService {
	private CartRepo cartRepo;
	private CartItemService cartItemService;
	private BookService bookService;
	
	public CartServiceImplementation(CartRepo cartRepo, CartItemService cartItemService, BookService bookService) {
		super();
		this.cartRepo = cartRepo;
		this.cartItemService = cartItemService;
		this.bookService = bookService;
	}

	@Override
	public Cart createCart(User user) {
		Cart cart = new Cart();
		cart.setUser(user);
		cartRepo.save(cart);
		return cart;
	}

	@Override
	public String addCartItem(Long userId, AddItemRequest req) throws BookException {
		Cart cart = cartRepo.findByUserId(userId);
		Book book = bookService.findBookById(req.getBookId());
		CartItem isPresent = cartItemService.isCartItemExist(book, cart, userId);
		
		if(isPresent==null) {
			CartItem cartItem = new CartItem();
			cartItem.setBook(book);
			cartItem.setCart(cart);
			cartItem.setQuantity(req.getQuantity());
			cartItem.setUserId(userId);
			
			int price = req.getQuantity()*book.getDiscountedPrice();
			cartItem.setPrice(price);
			
			CartItem createdCartItem = cartItemService.createCartItem(cartItem);
			cart.getCartItems().add(createdCartItem);
			return "Added items to cart";
		}
		
		throw new BookException("Requested book can't be added to cart");
	}

	@Override
	public Cart findUserCart(Long userId) {
		Cart cart = cartRepo.findByUserId(userId);
		
		int totalPrice = 0;
		int totalDiscountedPrice = 0;
		int totalItems = 0;
		
		for(CartItem item:cart.getCartItems()) {
			totalPrice += item.getPrice();
			totalDiscountedPrice += item.getDiscountedPrice();
			totalItems += item.getQuantity();
			
			cart.setTotalItem(totalItems);
			cart.setTotalDiscountedPrice(totalDiscountedPrice);
			cart.setTotalPrice(totalPrice);
			cart.setDiscount(totalPrice-totalDiscountedPrice);
		}
		
		return cartRepo.save(cart);
	}

}
