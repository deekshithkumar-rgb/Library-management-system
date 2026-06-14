package com.pentagon.LibraryManagementsystem.testController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.Service.CategoryService;
import com.pentagon.LibraryManagementsystem.entity.Category;

@RestController
public class CategoryController {

	@Autowired
	private CategoryService cs;
	
	@PostMapping("/category")
	public ResponseEntity<ResponceStructure<Category>>addBook(@RequestBody Category c){
		
		return cs.addBook(c);
	}
	
	@GetMapping("/allcategory")
	public ResponseEntity<ResponceStructure<List<Category>>>getAll(){
		
		return cs.getAll();
	}
}
