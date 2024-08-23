package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.CarrierDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Cargo;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Carriers;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;



@Service
public class CarrierService {
	@Autowired
	private CarrierDao carrierDao;
	
	public ResponseEntity<ResponseStructure<Carriers>>saveCarrier(Carriers carrier){
		Carriers carriers=carrierDao.saveCarrier(carrier);
		
		ResponseStructure<Carriers> responseStructure=new ResponseStructure<Carriers>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(carriers);
		
		return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure,HttpStatus.OK);
	}
	
	public ResponseEntity<ResponseStructure<List<Carriers>>> getAllCarrier() {
		List<Carriers> existingcarrier= carrierDao.getAllCarriers();
		ResponseStructure<List<Carriers>> responseStructure = new ResponseStructure<List<Carriers>>();
		responseStructure.setStatusCode(0);
		responseStructure.setMessage("Success");
		responseStructure.setData(existingcarrier);

		return new ResponseEntity<ResponseStructure<List<Carriers>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Carriers>> getCarrierById(int id){
		Carriers carrier=carrierDao.getCarrierById(id);
		
		if(carrier!=null) {
		ResponseStructure<Carriers> responseStructure=new ResponseStructure<Carriers>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succcess");
		responseStructure.setData(carrier);
		
		return new ResponseEntity<ResponseStructure<Carriers>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the table........");
		}
	}
	
	public ResponseEntity<ResponseStructure<Carriers>> updateCarrier(int id,Carriers updatedCarrier){
		Carriers existingCarrier=carrierDao.getCarrierById(id);
		
		if(existingCarrier!=null) {
			existingCarrier.setCarrierCompanyName(updatedCarrier.getCarrierCompanyName());
			existingCarrier.setCarrierContact(updatedCarrier.getCarrierContact());
			existingCarrier.setCarrierEmail(updatedCarrier.getCarrierEmail());
			existingCarrier.setDrivers(updatedCarrier.getDrivers());
			
			Carriers saveCarrier=carrierDao.saveCarrier(existingCarrier);
			
			ResponseStructure<Carriers> responseStructure=new ResponseStructure<Carriers>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(updatedCarrier);
			
			return new ResponseEntity<ResponseStructure<Carriers>>(HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table.........."); 
		}
	}
	
	public ResponseEntity<ResponseStructure<Carriers>> deleteCarrier(int id){
		Carriers carrier=carrierDao.getCarrierById(id);
		
		if(carrier!=null) {
			carrierDao.deleteCarrierById(id);
			
			ResponseStructure<Carriers> responseStructure=new ResponseStructure<Carriers>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(carrier);
			
			return new ResponseEntity<ResponseStructure<Carriers>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table...........");
		}
	}
}
