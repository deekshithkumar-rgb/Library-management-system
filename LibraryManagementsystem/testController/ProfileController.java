package com.pentagon.LibraryManagementsystem.testController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.Service.ProfileService;
import com.pentagon.LibraryManagementsystem.entity.Author;
import com.pentagon.LibraryManagementsystem.entity.Profile;

@RestController
public class ProfileController {

	@Autowired
	private ProfileService ps;
	
	@GetMapping("/saveprofile")
	public  ResponseEntity<ResponceStructure<Profile>> saveProfile(@PathVariable Profile p){
		
		return ps.saveProfile(p);
	}
	
	@GetMapping("/getall")
	public  ResponseEntity<ResponceStructure<List<Profile>>>getAllprofile(){
		
		return ps.getAllprofile();
	}
}
