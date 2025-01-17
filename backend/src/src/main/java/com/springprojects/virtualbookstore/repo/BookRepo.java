package com.springprojects.virtualbookstore.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.springprojects.virtualbookstore.model.Book;

@Repository
public interface BookRepo extends JpaRepository<Book, Long> {

	@Query("SELECT b FROM Book b WHERE (b.title =:title OR :title='') AND ((:minPrice IS NULL AND :maxPrice IS NULL) OR (b.discountedPrice BETWEEN :minPrice AND :maxPrice)) "
			+ "AND (:minDiscount IS NULL OR b.discountPercent>=:minDiscount) ORDER BY CASE WHEN :sort = 'price_low' THEN b.discountedPrice END ASC, CASE WHEN :sort = 'price_high' THEN b.discountedPrice END DESC")
	List<Book> filterBooks(@Param("title") String title, @Param("minPrice") int minPrice,
			@Param("maxPrice") int maxPrice, @Param("minDiscount") int minDiscount, @Param("sort") String sort);
}
