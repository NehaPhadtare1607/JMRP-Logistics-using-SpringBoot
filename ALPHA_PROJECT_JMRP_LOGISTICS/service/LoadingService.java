package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.Loadingdao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Loading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class LoadingService {
	
	@Autowired
	private Loadingdao loadingdao;
	
public ResponseEntity<ResponseStructure<Loading>>saveLoading(Loading loading){
		
		Loading receivedloading=loadingdao.saveLoading(loading);
		
		ResponseStructure<Loading> responseStructure=new ResponseStructure<Loading>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedloading);
		return new ResponseEntity<ResponseStructure<Loading>>(responseStructure,HttpStatus.CREATED);
		
	}
	
	public ResponseEntity<ResponseStructure<Loading>> getLoadingById(int id){
		Loading loading=loadingdao.getLoadingById(id);
		if(loading!=null) {
			ResponseStructure<Loading> responseStructure=new ResponseStructure<Loading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(loading);
			
			return new ResponseEntity<ResponseStructure<Loading>>(responseStructure,HttpStatus.OK);
			
		}
		else {
			throw new IdNotFoundException("ID :" +id+ " is not present in the database.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<List<Loading>>>getAllLoadings(){
		List<Loading> loading=loadingdao.getAllLoading();
		
		ResponseStructure<List<Loading>>responseStructure=new ResponseStructure<List<Loading>>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(loading);
		
		return new ResponseEntity<ResponseStructure<List<Loading>>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Loading>> updateLoading(int id,Loading updatedLoading){
		Loading existingloading=loadingdao.getLoadingById(id);
		
		if(existingloading!=null) {
			existingloading.setCompanyName(updatedLoading.getCompanyName());
			
			Loading saveLoading=loadingdao.saveLoading(existingloading);
			ResponseStructure<Loading> responseStructure=new ResponseStructure<Loading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updatedLoading);
			
			return new ResponseEntity<ResponseStructure<Loading>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Loading>> deleteLoadingById(int id){
		
		Loading loading=loadingdao.getLoadingById(id);
		if(loading!=null) {
			loadingdao.deleteLoading(id);
			
			ResponseStructure<Loading> responseStructure=new ResponseStructure<Loading>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(loading);
				
			return new ResponseEntity<ResponseStructure<Loading>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found....");
		}
	}	
}
