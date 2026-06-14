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
import com.pentagon.LibraryManagementsystem.Service.UserService;
import com.pentagon.LibraryManagementsystem.entity.Users;

@RestController
public class UserController {

	@Autowired
	private UserService us;
	
	@PostMapping("/user")
	public ResponseEntity<ResponceStructure<Users>>saveEmployee(@RequestBody Users u){
		
		return us.saveEmployee(u);
	}
	
	@GetMapping("/getalluser")
	public ResponseEntity<ResponceStructure<List<Users>>>getAllUser(){
		
		return us.getAllUser();
	}
	
	@GetMapping("/userfbid")
	public ResponseEntity<ResponceStructure<Users>>findUserById(@PathVariable int id){
		
		return us.findUserById(id);
	}
	
	@GetMapping("/updateuser")
	public ResponseEntity<ResponceStructure<Users>> UpdateUser(@RequestBody Users u){
		
		return us.UpdateUser(u);
	}
	
	@GetMapping("/deleteid")
	public ResponseEntity<ResponceStructure<String>> deleteUser(@PathVariable int id){
		
		return us.deleteUser(id);
	}
}
