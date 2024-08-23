package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.UserDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Users;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;



@Service
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	
	public ResponseEntity<ResponseStructure<Users>>saveUser(Users user){
		
		Users receivedProduct=userDao.saveUser(user);
		
		ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedProduct);
		return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Users>> getUserById(int id){
		Users user=userDao.getUserById(id);
		if(user!=null) {
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
			
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException("ID :" +id+ " is not present in the database.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Users>>>getAllUsers(){
		List<Users> user=userDao.getAllUser();
		
		ResponseStructure<List<Users>>responseStructure=new ResponseStructure<List<Users>>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(user);
		
		return new ResponseEntity<ResponseStructure<List<Users>>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Users>> updateUser(int id,Users updatedUser){
		Users existingUser=userDao.getUserById(id);
		
		if(existingUser!=null) {
			existingUser.setUserName(updatedUser.getUserName());
			existingUser.setUserPassword(updatedUser.getUserPassword());
			existingUser.setUserPhoneNumber(updatedUser.getUserPhoneNumber());
			existingUser.setUserRole(updatedUser.getUserRole());
			//existingUser.setOrders(updatedUser.getOrders());
			existingUser.setAddress(updatedUser.getAddress());
			
			Users saveUser=userDao.saveUser(existingUser);
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updatedUser);
			
			return new ResponseEntity<ResponseStructure<Users>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Users>> deleteUserById(int id){
		
		Users user=userDao.getUserById(id);
		if(user!=null) {
			userDao.deleteUserById(id);
			
			ResponseStructure<Users> responseStructure=new ResponseStructure<Users>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(user);
			
			
			return new ResponseEntity<ResponseStructure<Users>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found....");
		}
	}
	


}
