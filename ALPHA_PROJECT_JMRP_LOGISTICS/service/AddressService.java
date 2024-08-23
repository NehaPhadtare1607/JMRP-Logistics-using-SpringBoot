package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.AddressDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Address;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Users;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class AddressService {
	@Autowired
	private AddressDao addressDao;
	
	public ResponseEntity<ResponseStructure<Address>>saveAddress(Address address){
		Address receivedAddress=addressDao.saveAddress(address);
		ResponseStructure<Address>responseStructure=new ResponseStructure<Address>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedAddress);
		
		return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Address>>>getAllAddress(){
		List<Address>address=addressDao.getAllAddresss();
		
		ResponseStructure<List<Address>>responseStructure=new ResponseStructure<List<Address>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(address);
		
		return new ResponseEntity<ResponseStructure<List<Address>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Address>> getAddressById(int id){
		Address address=addressDao.getAddressById(id);
		if(address!=null) {
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(address);
			
			return new ResponseEntity<ResponseStructure<Address>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException("ID :" +id+ " is not present in the database.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>>updateAddress(int id,Address updatedAddress){
		Address existingaddress=addressDao.getAddressById(id);
		if(existingaddress!=null) {
			existingaddress.setStreetName(updatedAddress.getStreetName());
			existingaddress.setHouseNumber(updatedAddress.getHouseNumber());
			existingaddress.setAreaPincode(updatedAddress.getAreaPincode());
			existingaddress.setDistrict(updatedAddress.getDistrict());
			existingaddress.setState(updatedAddress.getState());
			existingaddress.setCountry(updatedAddress.getCountry());
			
			return new ResponseEntity<ResponseStructure<Address>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Address ID" +id+ " not found in the table");
		}
	}
	
	public ResponseEntity<ResponseStructure<Address>> deleteAddress(int id){
		Address address=addressDao.getAddressById(id);
		if(address!=null) {
			addressDao.deleteById(id);
			
			ResponseStructure<Address> responseStructure=new ResponseStructure<Address>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(address);
			
			return new ResponseEntity<ResponseStructure<Address>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Address ID" +id+ " not found in the table");	
		}
	}
}
