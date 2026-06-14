package com.pentagon.LibraryManagementsystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pentagon.LibraryManagementsystem.Dao.BookDao;
import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.Repository.BookRepository;
import com.pentagon.LibraryManagementsystem.Repository.UsersRepository;
import com.pentagon.LibraryManagementsystem.entity.Book;
import com.pentagon.LibraryManagementsystem.entity.Users;

@Service
public class BookService {

	@Autowired
	private BookDao bk;
	
	public ResponseEntity<ResponceStructure<Book>> addBook(Book b){
		Book book = bk.addBook(b);
		
		ResponceStructure<Book> response = new ResponceStructure<Book>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("Book added...!");
		response.setData(book);
		return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.CREATED);

	}
	
	public ResponseEntity<ResponceStructure<List<Book>>> getAllBooks(){
		List<Book> b= bk.getAllBooks();
		
		ResponceStructure<List<Book>> response = new ResponceStructure<List<Book>>();
		response.setStatuscode(HttpStatus.OK.value());
		response.setMessage("book fetched...!");
		response.setData(b);
		return new ResponseEntity<ResponceStructure<List<Book>>>(response,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponceStructure<Book>> borrow(int b_id,int u_id){
		Book b= bk.borrow(b_id , u_id);
		if(b != null) {
			ResponceStructure<Book> response = new ResponceStructure<Book>();
			response.setStatuscode(HttpStatus.OK.value());
			response.setMessage("books fetched...!");
			response.setData(b);
			return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.OK);
			
		}else {
			ResponceStructure<Book> response = new ResponceStructure<Book>();
			response.setStatuscode(HttpStatus.NOT_FOUND.value());
			response.setMessage("books not fetched fetched...!");
			response.setData(null);
			return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.NOT_FOUND);
		}
	}
	
//	public ResponseEntity<ResponceStructure<Book>> findBookById(int b_id){
//		Book b= bk.findBookById(b_id);
//		if(b != null) {
//			ResponceStructure<Book> response = new ResponceStructure<Book>();
//			response.setStatuscode(HttpStatus.OK.value());
//			response.setMessage("books returned...!");
//			response.setData(b);
//			return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.OK);
//		}else {
//			ResponceStructure<Book> response = new ResponceStructure<Book>();
//			response.setStatuscode(HttpStatus.OK.value());
//			response.setMessage("books not returned...!");
//			response.setData(null);
//			return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.OK);
//		}	
//	}
		
		public ResponseEntity<ResponceStructure<Book>> getById(int id){
	        Book b = bk.getById(id);
	        if(b != null){
	        	ResponceStructure<Book> response = new ResponceStructure<Book>();
	        	response.setStatuscode(HttpStatus.OK.value());
	            response.setMessage("Book found!");
	            response.setData(b);
	            return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.OK);

	        } else {

	        	ResponceStructure<Book> response = new ResponceStructure<Book>();
	        	response.setStatuscode(HttpStatus.NOT_FOUND.value());
	            response.setMessage("Book not found!");
	            response.setData(null);
	            return new ResponseEntity<ResponceStructure<Book>>(response,HttpStatus.NOT_FOUND);
	        }
	    }
}
