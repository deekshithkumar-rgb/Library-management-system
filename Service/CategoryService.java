package com.pentagon.LibraryManagementsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pentagon.LibraryManagementsystem.Dao.CategoryDao;
import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.entity.Category;

@Service
public class CategoryService {

	@Autowired
	private CategoryDao cry;
	
	public ResponseEntity<ResponceStructure<Category>> addBook(Category c){
		Category category = cry.addCategory(c);
		
		ResponceStructure<Category> response = new ResponceStructure<Category>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("Book added...!");
		response.setData(category);
		return new ResponseEntity<ResponceStructure<Category>>(response,HttpStatus.CREATED);

	}
	public ResponseEntity<ResponceStructure<List<Category>>> getAll(){
		List<Category> c = cry.getAll();
		
		ResponceStructure<List<Category>> response = new ResponceStructure<List<Category>>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("Book added...!");
		response.setData(c);
		return new ResponseEntity<ResponceStructure<List<Category>>>(response,HttpStatus.CREATED);

	}
	
	
}