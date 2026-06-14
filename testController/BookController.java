package com.pentagon.LibraryManagementsystem.testController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.Service.BookService;
import com.pentagon.LibraryManagementsystem.entity.Book;

@RestController
public class BookController {

	@Autowired
	private BookService bs;
	
	@PostMapping("/book")
	public ResponseEntity<ResponceStructure<Book>>addBook(@RequestBody Book b){
		
		return bs.addBook(b);
	}
	
	@GetMapping("/books")
	public ResponseEntity<ResponceStructure<List<Book>>>getAllBooks(){
		
		return bs.getAllBooks();
	}
	
	@GetMapping("/bookbr")
	public ResponseEntity<ResponceStructure<Book>>  borrow(@RequestParam int b_id, @RequestParam int u_id){
		
		return bs.borrow(b_id, u_id);
	}
	
	@GetMapping("/book/{id}")
	public ResponseEntity<ResponceStructure<Book>>getById(@PathVariable int id){
		
		return bs.getById(id);
	}
}
