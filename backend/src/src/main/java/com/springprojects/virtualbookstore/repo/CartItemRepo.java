package com.springprojects.virtualbookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springprojects.virtualbookstore.model.Book;
import com.springprojects.virtualbookstore.model.Cart;
import com.springprojects.virtualbookstore.model.CartItem;

public interface CartItemRepo extends JpaRepository<CartItem, Long>{
	@Query("SELECT ci FROM CartItem ci WHERE ci.cart=:cart AND ci.book=:book AND ci.userId=:userId")
	public CartItem isCartItemExist(@Param("cart") Cart cart, @Param("book") Book book, @Param("userId") Long userId);
}
