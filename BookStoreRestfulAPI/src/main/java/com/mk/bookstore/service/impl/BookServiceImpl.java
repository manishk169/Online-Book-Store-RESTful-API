package com.mk.bookstore.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mk.bookstore.entities.Book;
import com.mk.bookstore.repository.BoookRepository;
import com.mk.bookstore.service.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	private BoookRepository bookRepository;
	
	@Override
	public Book createBook(Book book)
	{
		return bookRepository.save(book);
	}

	@Override
	public List<Book> getAllBooks() 
	{
		return bookRepository.findAll();
	}

	@Override
	public Book getBookById(Long id) 
	{
        return bookRepository.findById(id).orElseThrow(()->new RuntimeException("Book not found"));
	}

	@Override
	public Book updateBook(Long id, Book updatedBook) 
	{
		Book book = getBookById(id);
		// Only update the fields that are provided (not null)
        if (updatedBook.getTitle() != null) {
            book.setTitle(updatedBook.getTitle());
        }
        if (updatedBook.getAuthor() != null) {
            book.setAuthor(updatedBook.getAuthor());
        }
        if (updatedBook.getPrice() != 0) {  // Assuming 0 is an invalid price in your case
            book.setPrice(updatedBook.getPrice());
        }
        if (updatedBook.getIsbn() != null) {
            book.setIsbn(updatedBook.getIsbn());
        }
        if (updatedBook.getStock() != 0) {
            book.setStock(updatedBook.getStock());
        }
        
        // Save the updated book
        return bookRepository.save(book);
	}

	@Override
	public void deleteBook(Long id) 
	{
		 bookRepository.deleteById(id);
	}

}
