package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.CargoDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Cargo;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class CargoService {

	@Autowired
	private CargoDao cargoDao;

	public ResponseEntity<ResponseStructure<Cargo>> saveCargo(Cargo cargo) {
		Cargo cargpo = cargoDao.saveCargo(cargo);

		ResponseStructure<Cargo> responseStructure = new ResponseStructure<Cargo>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(cargpo);

		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure, HttpStatus.CREATED);
	}

	public ResponseEntity<ResponseStructure<List<Cargo>>> getAllCargo() {
		List<Cargo> existingcargo = cargoDao.getAllCargo();
		ResponseStructure<List<Cargo>> responseStructure = new ResponseStructure<List<Cargo>>();
		responseStructure.setStatusCode(0);
		responseStructure.setMessage("Success");
		responseStructure.setData(existingcargo);

		return new ResponseEntity<ResponseStructure<List<Cargo>>>(responseStructure, HttpStatus.OK);
	}

	public ResponseEntity<ResponseStructure<Cargo>> getCargoById(int id){
		Cargo cargo=cargoDao.getCargoById(id);
		
		if(cargo!=null) {
		ResponseStructure<Cargo> responseStructure=new ResponseStructure<Cargo>();
		responseStructure.setStatusCode(HttpStatus.OK.value());
		responseStructure.setMessage("Succcess");
		responseStructure.setData(cargo);
		
		return new ResponseEntity<ResponseStructure<Cargo>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the table........");
		}
	}
	
	public ResponseEntity<ResponseStructure<Cargo>> updateCargo(int id,Cargo updatedCargo){
		Cargo existingcargo=cargoDao.getCargoById(id);
		
		if(existingcargo!=null) {
			existingcargo.setCargoName(updatedCargo.getCargoName());
			existingcargo.setCargoDescription(updatedCargo.getCargoDescription());
			existingcargo.setCargoWeight(updatedCargo.getCargoWeight());
			existingcargo.setCargoCount(updatedCargo.getCargoCount());
			
			Cargo saveCargo=cargoDao.saveCargo(existingcargo);
			
			ResponseStructure<Cargo> responseStructure=new ResponseStructure<Cargo>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("SUCCESS");
			responseStructure.setData(updatedCargo);
			
			return new ResponseEntity<ResponseStructure<Cargo>>(HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table.........."); 
		}
	}
	
	public ResponseEntity<ResponseStructure<Cargo>> deleteCargo(int id){
		Cargo cargo=cargoDao.getCargoById(id);
		
		if(cargo!=null) {
			cargoDao.deleteCargoById(id);
			
			ResponseStructure<Cargo> responseStructure=new ResponseStructure<Cargo>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(cargo);
			
			return new ResponseEntity<ResponseStructure<Cargo>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found in the table...........");
		}
	}
}
