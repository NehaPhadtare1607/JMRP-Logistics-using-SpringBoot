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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Truck;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.TruckService;

@RestController
@RequestMapping("/api/admin")
public class TruckController {
	@Autowired
	private TruckService truckService;
	
	@PostMapping("/savetruck")
	public ResponseEntity<ResponseStructure<Truck>>saveTruck(@RequestBody Truck truck){
		return truckService.saveTruck(truck);
	}
	
	@GetMapping("/getalltrucks")
	public ResponseEntity<ResponseStructure<List<Truck>>> getAllTrucks(){
		return truckService.getAllTrucks();
	}

	@GetMapping("/gettruckbyid/{id}")
	public ResponseEntity<ResponseStructure<Truck>> getTruckById(@PathVariable int id){
		return truckService.getTruckById(id);	 
	}
	
	@PutMapping("/updatetruck/{id}")
	public ResponseEntity<ResponseStructure<Truck>> updateTruck(@PathVariable int id,@RequestBody Truck truck){
		return truckService.updateTruck(id, truck);
	}
	
	@DeleteMapping("/deletetruckbyid/{id}")
	public  ResponseEntity<ResponseStructure<Truck>> deleteTruckById(@PathVariable int id){
		return truckService.deleteById(id);
	}
}