package com.springprojects.virtualbookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springprojects.virtualbookstore.model.Review;

public interface ReviewRepo extends JpaRepository<Review, Long>{
	@Query("Select r from Review r where r.bookId=:bookId")
	public List<Review> getAllBooksReview(@Param("bookId") Long bookId);
}
