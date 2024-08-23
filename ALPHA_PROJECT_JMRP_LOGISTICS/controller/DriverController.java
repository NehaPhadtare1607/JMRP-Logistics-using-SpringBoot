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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Driver;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.DriverService;

@RestController
@RequestMapping("/api/admin")
public class DriverController {
	
	@Autowired
	private DriverService driverService;
	
	@PostMapping("/savedriver")
	public ResponseEntity<ResponseStructure<Driver>> saveDriver(@RequestBody Driver driver){
		return driverService.saveDriver(driver);
		
	}
	@GetMapping("/getalldrivers")
	public ResponseEntity<ResponseStructure<List<Driver>>> getAllDriver(){
		return driverService.getAllDrivers();
	}

	@GetMapping("/getdriver/{id}")
	public ResponseEntity<ResponseStructure<Driver>> getDriverById(@PathVariable int id){
		return driverService.getDriverById(id);
	}
	
	@PutMapping("/updatedriver/{id}")
	public ResponseEntity<ResponseStructure<Driver>> updateDriver(@PathVariable int id,@RequestBody Driver driver){
		return driverService.updateDriver(id, driver);
		
	}
	
	@DeleteMapping("/deletedriver/{id}")
	public ResponseEntity<ResponseStructure<Driver>> deleteDriver(@PathVariable int id){
		return driverService.deleteDriverById(id);
	}
}
