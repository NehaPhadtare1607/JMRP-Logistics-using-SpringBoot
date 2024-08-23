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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Loading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.LoadingService;

@RestController
@RequestMapping("/api/admin")
public class LoadingController {
	@Autowired
	private LoadingService loadingService;
	
	@PostMapping("/saveloading")
	public ResponseEntity<ResponseStructure<Loading>> saveLoading(@RequestBody Loading loading){
		return loadingService.saveLoading(loading); 
	}
	
	@GetMapping("/getallloading")
	public ResponseEntity<ResponseStructure<List<Loading>>> getAllLoadings(){
		return loadingService.getAllLoadings();
	}
	
	@GetMapping("/getLoadingById/{id}")
	public ResponseEntity<ResponseStructure<Loading>> getLoadingById(@PathVariable int id){
		return loadingService.getLoadingById(id);
	}
	
	@PutMapping("/updateloading/{id}")
	public ResponseEntity<ResponseStructure<Loading>> updateLoading(@PathVariable int id,@RequestBody Loading loading){
		return loadingService.updateLoading(id, loading);
	}
	
	@DeleteMapping("/deleteloadingbyid/{id}")
	public ResponseEntity<ResponseStructure<Loading>> deleteLoading(@PathVariable int id){
		return loadingService.deleteLoadingById(id);
	}
}
