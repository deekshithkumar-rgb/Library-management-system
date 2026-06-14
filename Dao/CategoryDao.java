package com.pentagon.LibraryManagementsystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pentagon.LibraryManagementsystem.Repository.CategoryRepository;
import com.pentagon.LibraryManagementsystem.entity.Author;
import com.pentagon.LibraryManagementsystem.entity.Category;

@Repository
public class CategoryDao {

	@Autowired
	private CategoryRepository category;
	
	public Category addCategory(Category c) {
		return category.save(c);
		
	}
	
	public List<Category> getAll()
	{
		return category.findAll();
	}
}
