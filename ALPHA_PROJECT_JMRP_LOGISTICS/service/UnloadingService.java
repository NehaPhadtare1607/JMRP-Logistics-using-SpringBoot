package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.UnloadingDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Unloading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class UnloadingService {
	@Autowired
	private UnloadingDao unloadingdao;
	
	public ResponseEntity<ResponseStructure<UnloadingService>>saveUnloading(Unloading unloading){
		Unloading receivedUnloading=unloadingdao.saveUnloading(unloading);
		
		ResponseStructure<Unloading> responseStructure=new ResponseStructure<Unloading>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedUnloading);
		return new ResponseEntity<ResponseStructure<UnloadingService>>(HttpStatus.OK);
		
	}
	
	public ResponseEntity<ResponseStructure<Unloading>> getUnLoadingById(int id){
		Unloading unloading=unloadingdao.getUnloadingById(id);
		if(unloading!=null) {
			ResponseStructure<Unloading> responseStructure=new ResponseStructure<Unloading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(unloading);
			
			return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("ID :" +id+ " is not present in the database.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Unloading>>>getAllUnLoadings(){
		List<Unloading> unloading=unloadingdao.getAllUnloadings();
		
		ResponseStructure<List<Unloading>>responseStructure=new ResponseStructure<List<Unloading>>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(unloading);
		
		return new ResponseEntity<ResponseStructure<List<Unloading>>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Unloading>> updateUnLoading(int id,Unloading updatedUnLoading){
		Unloading existingUnloading=unloadingdao.getUnloadingById(id);
		
		if(existingUnloading!=null) {
			existingUnloading.setCompanyName(updatedUnLoading.getCompanyName());
			
			Unloading saveUnLoading=unloadingdao.saveUnloading(existingUnloading);
			ResponseStructure<Unloading> responseStructure=new ResponseStructure<Unloading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updatedUnLoading);
			
			return new ResponseEntity<ResponseStructure<Unloading>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the database");
		}
	}

public ResponseEntity<ResponseStructure<Unloading>> deleteUnLoadingById(int id){
		
		Unloading unloading=unloadingdao.getUnloadingById(id);
		if(unloading!=null) {
			unloadingdao.deleteUnloading(id);
			
			ResponseStructure<Unloading> responseStructure=new ResponseStructure<Unloading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(unloading);
				
			return new ResponseEntity<ResponseStructure<Unloading>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found....");
		}
	}
}
