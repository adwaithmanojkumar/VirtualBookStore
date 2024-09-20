package com.springprojects.virtualbookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.springprojects.virtualbookstore.model.Rating;

public interface RatingRepo extends JpaRepository<Rating, Long>{
	@Query("Select r from Rating r where r.bookId=:bookId")
	public List<Rating> getAllBooksRating(@Param("bookId") Long bookId);
}
