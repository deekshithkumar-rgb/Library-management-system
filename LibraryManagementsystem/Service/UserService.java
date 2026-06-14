package com.pentagon.LibraryManagementsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pentagon.LibraryManagementsystem.Dao.UserDao;
import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.entity.Book;
import com.pentagon.LibraryManagementsystem.entity.Category;
import com.pentagon.LibraryManagementsystem.entity.Users;
import com.pentagon.LibraryManagementsystem.entity.Users;

@Service
public class UserService {

	@Autowired
	private UserDao ur;
	
	public ResponseEntity<ResponceStructure<Users>> saveEmployee(Users u){
		Users user=ur.saveEmployee(u);
		
		ResponceStructure<Users> response = new ResponceStructure<Users>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("Book added...!");
		response.setData(user);
		return new ResponseEntity<ResponceStructure<Users>>(response,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponceStructure<List<Users>>> getAllUser(){
	List <Users>user=ur.getAllUser();
		
		ResponceStructure<List<Users> >response = new ResponceStructure<List<Users>>();
		response.setStatuscode(HttpStatus.OK.value());
		response.setMessage("Book added...!");
		response.setData(user);
		return new ResponseEntity<ResponceStructure<List<Users>>>(response,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponceStructure<Users>> findUserById(int id){
		Users u= ur. getById(id);
		if(u != null) {
			ResponceStructure<Users> response = new ResponceStructure<Users>();
			response.setStatuscode(HttpStatus.OK.value());
			response.setMessage("Users returned...!");
			response.setData(u);
			return new ResponseEntity<ResponceStructure<Users>>(response,HttpStatus.OK);
		}else {
			ResponceStructure<Users> response = new ResponceStructure<Users>();
			response.setStatuscode(HttpStatus.OK.value());
			response.setMessage("Users not returned...!");
			response.setData(null);
			return new ResponseEntity<ResponceStructure<Users>>(response,HttpStatus.OK);
		}	
	}
	
	public ResponseEntity<ResponceStructure<Users>> UpdateUser(Users u){

      Users user= ur.update(u);
		
		ResponceStructure<Users> response = new ResponceStructure<Users>();
		response.setStatuscode(HttpStatus.CREATED.value());
		response.setMessage("updated...!");
		response.setData(user);
		return new ResponseEntity<ResponceStructure<Users>>(response,HttpStatus.OK);

	}
	
	public ResponseEntity<ResponceStructure<String>> deleteUser(int id){

	      String user= ur.delete(id);
			
			ResponceStructure<String> response = new ResponceStructure<String>();
			response.setStatuscode(HttpStatus.OK.value());
			response.setMessage("deleted...!");
			response.setData(user);
			return new ResponseEntity<ResponceStructure<String>>(response,HttpStatus.OK);

		}
}
