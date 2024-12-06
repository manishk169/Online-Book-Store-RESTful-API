package com.mk.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mk.bookstore.entities.Book;

public interface BoookRepository extends JpaRepository<Book, Long>{
	
}
