package com.pentagon.LibraryManagementsystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.pentagon.LibraryManagementsystem.Dao.ProfileDao;
import com.pentagon.LibraryManagementsystem.Dto.ResponceStructure;
import com.pentagon.LibraryManagementsystem.entity.Book;
import com.pentagon.LibraryManagementsystem.entity.Profile;
import com.pentagon.LibraryManagementsystem.entity.Users;

@Service
public class ProfileService {

	@Autowired
	private ProfileDao pd;
	
	public ResponseEntity<ResponceStructure<Profile>> saveProfile(Profile p){
		Profile profile=pd.save(p);
		
		ResponceStructure<Profile> response = new ResponceStructure<Profile>();
		response.setStatuscode(HttpStatus.OK.value());
		response.setMessage("Profile saved...!");
		response.setData(profile);
		return new ResponseEntity<ResponceStructure<Profile>>(response,HttpStatus.OK);
	}
	public ResponseEntity<ResponceStructure<List<Profile>>> getAllprofile(){
		List<Profile> p= pd.getAllProfile();
		
		ResponceStructure<List<Profile>> response = new ResponceStructure<List<Profile>>();
		response.setStatuscode(HttpStatus.OK.value());
		response.setMessage("profile fetched...!");
		response.setData(p);
		return new ResponseEntity<ResponceStructure<List<Profile>>>(response,HttpStatus.OK);

	}
	
}
