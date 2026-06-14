package com.pentagon.LibraryManagementsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.pentagon.LibraryManagementsystem.Repository.AuthorRepository;
import com.pentagon.LibraryManagementsystem.entity.Author;
import com.pentagon.LibraryManagementsystem.entity.Book;

@Repository
public class AuthorDao {

	@Autowired
	private AuthorRepository author;
	
	public Author addAuthor(Author a) {
		return author.save(a);
		
	}
	
	public List<Author> getAllAuthor(){
		return author.findAll();
	}
	public List<Book> getBooks(int id){
		Optional<Author> o=author.findById(id);
		if(o.isPresent()) {
			Author a=o.get();
			return a.getBook();
				
		}
		else {
			return null;
		}
		
	}
	
	
}
  