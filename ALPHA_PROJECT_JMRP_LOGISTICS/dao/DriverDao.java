package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Driver;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.DriverRepository;

@Repository
public class DriverDao {
	@Autowired
	private DriverRepository driverRepository;
	
	public Driver saveDriver(Driver driver) {
		return driverRepository.save(driver);
	}
	
	public List<Driver> getAllDrivers() {
		List<Driver> driver= driverRepository.findAll();
		return driver;
	}
	
	public Driver getDriverById(int id) {
		Optional<Driver> optional=driverRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateDriver(int id,Driver driver) {
		driverRepository.save(driver);
		return "Driver records are updated......";
	}
	
	public String deleteDriverById(int id) {
		Optional<Driver>optional= driverRepository.findById(id);
		if(optional.isPresent()) {
			driverRepository.deleteById(id);
			return " Driver records are deleted.....";
		}
		else {
			return "no records are deleted in the table ";
		}
		
	}

}
