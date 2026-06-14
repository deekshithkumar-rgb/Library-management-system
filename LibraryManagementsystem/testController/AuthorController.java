package com.pentagon.LibraryManagementsystem.testController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.Service.AuthorService;
import com.pentagon.LibraryManagementsystem.entity.Author;
import com.pentagon.LibraryManagementsystem.entity.Book;

@RestController
public class AuthorController {

	@Autowired
	private AuthorService au;
	
	@PostMapping("/author")
	public ResponseEntity<ResponceStructure<Author>> AddAuthor(@RequestBody Author a){
		
		return au.AddAuthor(a);
	}
	
	@GetMapping("/authors")
	public ResponseEntity<ResponceStructure<List<Author>>> getAllAuthor(){
		
		return au.getAllAuthor();
	}
	
	@GetMapping("/author/books/{id}")
	public ResponseEntity<ResponceStructure<List<Book>>>getBooks(@PathVariable int id){
		
		return au.getBooks(id);
	}
}
