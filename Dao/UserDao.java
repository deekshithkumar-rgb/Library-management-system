package com.pentagon.LibraryManagementsystem.Dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pentagon.LibraryManagementsystem.Repository.UsersRepository;
import com.pentagon.LibraryManagementsystem.entity.Users;
import com.pentagon.LibraryManagementsystem.entity.Users;

@Repository
public class UserDao {

	@Autowired
	private UsersRepository ur;
	
	public Users saveEmployee(Users u) {
		return ur.save(u);
	}
	
	public List<Users> getAllUser(){
		return ur.findAll();
	}
	
	public Users getById(int id) {
		Optional<Users> o=ur.findById(id);
		if(o.isPresent()) {
			return o.get();
		}
		else {
			return null;
		}
	} 
	
	public Users update(Users u) {
		int id=u.getId();
		Optional<Users> o = ur.findById(id);
		if(o.isPresent()) {
			return ur.save(u);
		}else {
			return null;
		}
	}
		
	public String delete(int id) {
		Optional<Users> o = ur.findById(id);
		if(o.isPresent()) {
			Users u = o.get();
			ur.delete(u);
			
			return "User Deleted";
			}else {
			return "User Not Deleted";
		}
	}
}
