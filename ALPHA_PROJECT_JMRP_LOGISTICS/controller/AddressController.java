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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Address;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.AddressService;

@RestController
@RequestMapping("/api/admin")
public class AddressController {
	
	@Autowired
	private AddressService addressService;
	
	
	@PostMapping("/saveaddress")
	public ResponseEntity<ResponseStructure<Address>>saveAddress(@RequestBody Address address){
		return addressService.saveAddress(address);	
	}
	
	
	@GetMapping("/getaddressbyid/{id}")
	public ResponseEntity<ResponseStructure<Address>>getAddressById(@PathVariable int id){
		return addressService.getAddressById(id);
	}
	
	@GetMapping("/getalladdress")
	public ResponseEntity<ResponseStructure<List<Address>>> getAllAddress(){
		return addressService.getAllAddress();
	}
	
	@PutMapping("/updateaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>> updateAddress(@PathVariable int id,@RequestBody Address address){
		return addressService.updateAddress(id, address);		
	}
	
	@DeleteMapping("/deleteaddress/{id}")
	public ResponseEntity<ResponseStructure<Address>>deleteAddress(@PathVariable int id){
		return addressService.deleteAddress(id);
	}
}
