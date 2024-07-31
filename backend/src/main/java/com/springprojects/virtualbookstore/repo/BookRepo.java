package com.springprojects.virtualbookstore.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springprojects.virtualbookstore.entity.Book;

public interface BookRepo extends JpaRepository<Book, Integer>{

}
