package com.pentagon.LibraryManagementsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pentagon.LibraryManagementsystem.Repository.BookRepository;
import com.pentagon.LibraryManagementsystem.Repository.UsersRepository;
import com.pentagon.LibraryManagementsystem.Repository.UsersRepository;
import com.pentagon.LibraryManagementsystem.entity.Book;
import com.pentagon.LibraryManagementsystem.entity.Users;
import com.pentagon.LibraryManagementsystem.entity.Users;

@Repository
public class BookDao {

	@Autowired
	private BookRepository book;
	
	@Autowired
	private UsersRepository user;
	
	public Book addBook(Book b) {
		return book.save(b);
	}
	
	public List<Book> getAllBooks(){
	return book.findAll();
	}
	public Book borrow(int b_id,int u_id) {
		
		Optional<Book> bookOpt = book.findById(b_id);
		Optional<Users> userOpt = user.findById(u_id);
		
		//if book or user not found
		
		if(bookOpt.isEmpty()|| userOpt.isEmpty()) {
			return null;
		}
		Book b = bookOpt.get();
		
		//book alredy borrowed
		
		if(b.getUser() != null) {
			return null;
		}
		Users u= userOpt.get();
		
		//owning side update
		b.setUser(u);
		
		return book.save(b);
	
	}
	public Book returnBook(int id) {
		Optional<Book> booko=book.findById(id);
		if(booko.isPresent()) {
			Book b= booko.get();
			b.setUser(null);
			return book.save(b);
		}
		else {
			return null;
		}
	}
	public Book getById(int id) {
		Optional<Book> o=book.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else {
			return null;
		}
		
	}
}
