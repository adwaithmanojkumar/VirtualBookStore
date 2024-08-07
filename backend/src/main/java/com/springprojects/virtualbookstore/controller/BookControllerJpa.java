package com.springprojects.virtualbookstore.controller;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.springprojects.virtualbookstore.entity.Book;
import com.springprojects.virtualbookstore.entity.Cart;
import com.springprojects.virtualbookstore.repo.BookRepo;
import com.springprojects.virtualbookstore.repo.CartRepo;
import com.springprojects.virtualbookstore.security.SpringSecurityConfiguration;

import jakarta.validation.Valid;
@Controller
public class BookControllerJpa {
	private BookRepo bookRepo;
	private CartRepo cartRepo;

	/**
	 * @param bookRepo
	 */
	public BookControllerJpa(BookRepo bookRepo,CartRepo cartRepo) {
		this.bookRepo = bookRepo;
		this.cartRepo = cartRepo;
	}
	
	@GetMapping(path="basicAuth")
	public String basicAuth() {
		return "redirect:/";
	}
	
	@GetMapping(path = "/") 
	public String welcomePage() {
		return "welcome";
	}
	
	@GetMapping(path = "book-list") 
	public String findBooks(ModelMap model) { 
		List<Book> booklist = bookRepo.findAll();
		model.addAttribute("booklist",booklist);
		System.out.println(booklist.toString());
		return "bookList";
	}
	
	@GetMapping(path = "add-book") 
	public String showNewBookPage(ModelMap model) { 
		Book book = new Book(0,"","",LocalDate.now());
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@GetMapping(path = "update-book/{id}")
	public String updateBook(ModelMap model, @PathVariable int id) {
		Book book = bookRepo.findById(id).orElse(null);
		if(book==null) {
			return "redirect:/book-list";
		}
		model.addAttribute("book", book);
		return "addBook";
	}
	
	@PostMapping(path = "add-book")
	public String addNewBook(ModelMap model, @Valid @ModelAttribute("book") Book book, BindingResult result) {
		if (result.hasErrors()) {
			return "addBook";
		}
		bookRepo.save(book);
		return "redirect:/book-list";
	}
	
//	@PostMapping(path = "update-book") 
//	public String showUpdateBookPage(ModelMap model,@Valid @ModelAttribute("book") Book book,BindingResult result) { 
//		if(result.hasErrors()) {
//			return "updateBook";
//		}
//		bookRepo.save(book);
//		return "redirect:/book-list";
//	}
	
	@GetMapping(path = "cart-list")
	public String getCartDetails(ModelMap model) {
		List<Cart> cartlist = cartRepo.findByUserName(getLoggedUserName(model));
		model.addAttribute("cartlist", cartlist);
		return "cartList";
	}
	
	@GetMapping(path = "add-to-cart/{id}")
	public String addToCart(@PathVariable int id,ModelMap model) {
		try {
			Book book = bookRepo.getReferenceById(id);
			Cart cart = new Cart(book.getId(),book.getBookName(),book.getAuthorName(),book.getPublishedDate());
			cart.setUserName(getLoggedUserName(model));
			cartRepo.save(cart);
			return "redirect:/cart-list";
		} catch (Exception e) {
			return "error";
		}
	}
	
	@GetMapping(path = "remove-from-cart/{id}")
	public String removeFromCart(@PathVariable int id,ModelMap model) {
		cartRepo.deleteById(id);
		return "redirect:/cart-list";
	}
	
	private String getLoggedUserName(ModelMap model) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
}
