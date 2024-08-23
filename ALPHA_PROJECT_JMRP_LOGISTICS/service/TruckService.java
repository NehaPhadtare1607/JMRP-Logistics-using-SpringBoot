package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.TruckDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Truck;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class TruckService {
	
	@Autowired
	private TruckDao truckDao;
	
	public ResponseEntity<ResponseStructure<Truck>>saveTruck(Truck truck){
		Truck receivedTruck=truckDao.saveTruck(truck);
		ResponseStructure<Truck> responseStructure=new ResponseStructure<Truck>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedTruck);
		
		return new ResponseEntity<ResponseStructure<Truck>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<List<Truck>>> getAllTrucks(){
		List<Truck> truck=truckDao.getAllTrucks();
		ResponseStructure<List<Truck>> responseStructure=new ResponseStructure<List<Truck>>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("SUCCESS");
		responseStructure.setData(truck);
		return new ResponseEntity<ResponseStructure<List<Truck>>>(responseStructure,HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Truck>> getTruckById(int id){
		Truck truck=truckDao.getTruckById(id);
		if(truck!=null) {
			ResponseStructure<Truck> responseStructure=new ResponseStructure<Truck>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(truck);
			
			return new ResponseEntity<ResponseStructure<Truck>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<Truck>> updateTruck(int id,Truck updatedtruck){
		Truck existingtruck=truckDao.getTruckById(id);
		if(existingtruck!=null) {
			existingtruck.setName(updatedtruck.getName());
			existingtruck.setRegisteredNumber(updatedtruck.getRegisteredNumber());
			existingtruck.setCapacity(updatedtruck.getCapacity());
			existingtruck.setStatus(updatedtruck.getStatus());
			existingtruck.setCarrierId(updatedtruck.getCarrierId());
			
			Truck savetruck=truckDao.saveTruck(existingtruck);
			ResponseStructure<Truck> responseStructure=new ResponseStructure<Truck>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(updatedtruck);
			
			return new ResponseEntity<ResponseStructure<Truck>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table........."); 
		}
	}
	
	public ResponseEntity<ResponseStructure<Truck>> deleteById(int id){
		Truck truck=truckDao.getTruckById(id);
		if(truck!=null) {
			truckDao.deleteTruckById(id);
			
			ResponseStructure<Truck> responseStructure=new ResponseStructure<Truck>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(truck);
			
			return new ResponseEntity<ResponseStructure<Truck>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Truck Id " +id+ " is not present in the table..........");
		}
	}

}
