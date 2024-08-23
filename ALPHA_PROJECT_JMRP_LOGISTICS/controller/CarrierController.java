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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Carriers;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.CarrierService;

@RestController
@RequestMapping("/api/admin")
public class CarrierController {
	@Autowired
	private CarrierService carrierService;
	
	@PostMapping("/savecarrier")
	public ResponseEntity<ResponseStructure<Carriers>>saveCarrier(@RequestBody Carriers carrier){
		return carrierService.saveCarrier(carrier);
		
	}
	@GetMapping("/getcarrierbyid/{id}")
	public ResponseEntity<ResponseStructure<Carriers>>getCarrierById(@PathVariable int id){
		return carrierService.getCarrierById(id);
	}
	
	@GetMapping("/getallcarrier")
	public ResponseEntity<ResponseStructure<List<Carriers>>> getAllCarriers(){
		return carrierService.getAllCarrier();
	}
	
	@PutMapping("/updatecarrier/{id}")
	public ResponseEntity<ResponseStructure<Carriers>> updateCarriers(@PathVariable int id,@RequestBody Carriers carrier){
		return carrierService.updateCarrier(id, carrier);
	}
	
	@DeleteMapping("/deletecarrier/{id}")
	public ResponseEntity<ResponseStructure<Carriers>> deleteCarrierById(@PathVariable int id){
		return carrierService.deleteCarrier(id);
	}

}
