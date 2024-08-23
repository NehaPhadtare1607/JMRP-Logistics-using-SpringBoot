package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.DriverDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Driver;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class DriverService {
	@Autowired
	private DriverDao driverDao;
	
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(Driver driver){
		Driver drivers=driverDao.saveDriver(driver);
		
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(drivers);
		
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Driver>> getDriverById(int id){
		Driver drivers=driverDao.getDriverById(id);
		
		if(drivers!=null) {
		
		ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(drivers);
		
		return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the table........");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDrivers(){
		List<Driver> drivers=driverDao.getAllDrivers();

			ResponseStructure<List<Driver>> responseStructure=new ResponseStructure<List<Driver>>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(drivers);
			
			return new ResponseEntity<ResponseStructure<List<Driver>>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(int id,Driver updateddriver){
		Driver existingdriver=driverDao.getDriverById(id);
		
		if(existingdriver!=null) {
			existingdriver.setDriverName(updateddriver.getDriverName());
			existingdriver.setDriverPhoneNumber(updateddriver.getDriverPhoneNumber());
			existingdriver.setTruckRegisteredNumber(updateddriver.getTruckRegisteredNumber());
			
			Driver saveDriver=driverDao.saveDriver(existingdriver);
			ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updateddriver);
			
			return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table.........."); 
		}	
	}
	
	public ResponseEntity<ResponseStructure<Driver>> deleteDriverById(int id){
		Driver driver=driverDao.getDriverById(id);
		
		if(driver!=null) {
			driverDao.deleteDriverById(id);
			
			ResponseStructure<Driver> responseStructure=new ResponseStructure<Driver>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(driver);
			
			return new ResponseEntity<ResponseStructure<Driver>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table...........");
		}
	}
			
		

	
	

}
