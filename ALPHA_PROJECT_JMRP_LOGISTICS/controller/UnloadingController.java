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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Unloading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.UnloadingService;

@RestController
@RequestMapping("/api/admin")
public class UnloadingController {
	@Autowired
	private UnloadingService unloadingService;
	
	@PostMapping("/saveunloading")
	public ResponseEntity<ResponseStructure<UnloadingService>> saveUnLoading(@RequestBody Unloading unloading){
		return unloadingService.saveUnloading(unloading); 
	}
	
	@GetMapping("/getallunloading")
	public ResponseEntity<ResponseStructure<List<Unloading>>> getAllUnLoadings(){
		return unloadingService.getAllUnLoadings();
	}
	
	@GetMapping("/getunloadingById/{id}")
	public ResponseEntity<ResponseStructure<Unloading>> getLoadingById(@PathVariable int id){
		return unloadingService.getUnLoadingById(id);
	}
	
	@PutMapping("/updateunloading/{id}")
	public ResponseEntity<ResponseStructure<Unloading>> updateLoading(@PathVariable int id,@RequestBody Unloading unloading){
		return unloadingService.updateUnLoading(id, unloading);
	}
	
	@DeleteMapping("/deletebyid/{id}")
	public ResponseEntity<ResponseStructure<Unloading>> deleteUnLoading(@PathVariable int id){
		return unloadingService.deleteUnLoadingById(id);
	}

}
