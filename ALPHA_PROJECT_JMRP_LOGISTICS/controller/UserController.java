package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Users;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.UserService;



@RestController
@RequestMapping("/api/admin")
public class UserController {
	
	@Autowired
	UserService userService;

	@PostMapping("/saveuser")
	public ResponseEntity<ResponseStructure<Users>> saveUser(@RequestBody Users user){
		return userService.saveUser(user);
		
	}
	
	@GetMapping("/getallusers")
	public ResponseEntity<ResponseStructure<List<Users>>>getAllUsers(){
		return userService.getAllUsers();
	}
	
	@GetMapping("/getuserbyid/{id}")
	public ResponseEntity<ResponseStructure<Users>>getUserById(@PathVariable int id){
		return userService.getUserById(id);
	}
	
	@PutMapping("/updateuser/{id}")
	public ResponseEntity<ResponseStructure<Users>> updateUser(@PathVariable int id,@RequestBody Users user){
		return userService.updateUser(id, user);
	}
	@DeleteMapping("/deleteuser/{id}")
	public ResponseEntity<ResponseStructure<Users>> deleteUserById(@PathVariable int id){
		return userService.deleteUserById(id);
	}
}
