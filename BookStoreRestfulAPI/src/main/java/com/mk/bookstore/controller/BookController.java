package com.mk.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.mk.bookstore.entities.Book;
import com.mk.bookstore.service.impl.BookServiceImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PutMapping;



@RestController
@RequestMapping("/api/books")
public class BookController {

//	baseUrl = "http://localhost:8080/api/books"
//Book Module: 1. Getting All Books               (GET):            /getbooks
//	           2. Getting Book by book ID         (GET):      /getbooks/{id}
//	           3. Inserting a book               (POST):      /insertbook
//             4. Updating a book by book ID      (PUT):   /updatebook/{id}
//             5. Deleting a book by book  ID  (DELETE):  /deletebook/{id}
	
	@Autowired
	BookServiceImpl bookServiceImpl;
	
	@GetMapping("/home")
	public String homepae()
	{
		return "This is a home page for Bookstore API";
	}
	
	//get all books in the database
	@GetMapping("/getbooks")
    public List<Book> showAllBooks() {
        return bookServiceImpl.getAllBooks();
    }
	
	//get a book by id
	@GetMapping("/getbooks/{id}")
	public ResponseEntity<Book> showBookbyId(@PathVariable Long id){
		return ResponseEntity.ok(bookServiceImpl.getBookById(id));
	}
	
	//insert a book in the database
	@PostMapping("/insertbook")
	public ResponseEntity<Book> addBook(@RequestBody Book book) {
		
		return ResponseEntity.ok(bookServiceImpl.createBook(book));
	}
	
	@PutMapping("updatebook/{id}")
	public ResponseEntity<Book> editBook(@PathVariable Long id, @RequestBody Book book) {
	
		return ResponseEntity.ok(bookServiceImpl.updateBook(id, book));
	}
	
	
	@DeleteMapping("deletebook/{id}")
	public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
	    bookServiceImpl.deleteBook(id);
	    return ResponseEntity.noContent().build();
	}

	/* some data for inserting books
  {
    "title": "Head First Design Patterns",
    "author": "Eric Freeman",
    "price": 49.99,
    "isbn": "9780596007126",
    "stock": 75
  },
  {
    "title": "Java: The Complete Reference",
    "author": "Herbert Schildt",
    "price": 64.99,
    "isbn": "9781260440232",
    "stock": 20
  }*/

}
