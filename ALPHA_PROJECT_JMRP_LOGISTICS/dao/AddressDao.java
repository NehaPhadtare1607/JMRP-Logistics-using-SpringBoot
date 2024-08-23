package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Address;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Users;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.AddressRepository;

@Repository
public class AddressDao {
	
	@Autowired
	private AddressRepository addressRepository;
	
	public Address saveAddress(Address address) {
		return addressRepository.save(address);
	}
	
	public List<Address> getAllAddresss() {
		List<Address> address= addressRepository.findAll();
		return address;
	}
	
	public Address getAddressById(int id) {
		Optional<Address> optional=addressRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}

	public String updateAddress(Address address) {
		addressRepository.save(address);
		return "Address updated successfully....";
	}
	
	public String deleteById(int id) {
		Optional<Address> optional=addressRepository.findById(id);
		
		if(optional.isPresent()) {
			addressRepository.deleteById(id);
			return "address record is deleted";
		}
		else {
			return "no records found in the table";
		}
		
	}
	

}
