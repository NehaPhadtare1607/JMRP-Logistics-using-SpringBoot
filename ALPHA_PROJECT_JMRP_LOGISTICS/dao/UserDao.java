package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Users;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.UserRepository;

@Repository
public class UserDao {
	
	@Autowired
	private UserRepository userrepository;

	
	public Users saveUser(Users user) {
		return userrepository.save(user);
	}
	
	
	public List<Users> getAllUser() {
		List<Users> user= userrepository.findAll();
		return user;
	}
	
	public Users getUserById(int id) {
		Optional<Users> optional=userrepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateUser(Users user) {
		userrepository.save(user);
		return "user data is updated....";
	}
	
	public String deleteUserById(int id) {
		Optional<Users>optional=userrepository.findById(id);
		if(optional.isPresent()) {
			userrepository.deleteById(id);
			return "user record is deleted....";
		}
		else {
			return "no records are found in the table....";
		}
	}
	
}
