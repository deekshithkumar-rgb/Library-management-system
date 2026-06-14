package com.pentagon.LibraryManagementsystem.Dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.pentagon.LibraryManagementsystem.Repository.ProfileRepository;
import com.pentagon.LibraryManagementsystem.entity.Profile;

@Repository
public class ProfileDao {

	@Autowired
	private ProfileRepository profile;
	
	
	
	public Profile save(Profile p) {
		return profile.save(p);
	}
	
	public List<Profile>getAllProfile(){
		return profile.findAll();
	}
}
