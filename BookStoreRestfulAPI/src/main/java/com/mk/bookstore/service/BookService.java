package com.mk.bookstore.service;

import java.util.List;


import com.mk.bookstore.entities.Book;

public interface BookService {

	 public Book createBook(Book book); 
	 
	 public List<Book> getAllBooks();
	 
	 public Book getBookById(Long id);
	 
	 public Book updateBook(Long id, Book updatedBook);
	 
	 public void deleteBook(Long id);
	 
	 
}
