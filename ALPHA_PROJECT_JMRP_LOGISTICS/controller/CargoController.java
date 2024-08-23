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
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Cargo;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.CargoService;

@RestController
@RequestMapping("/api/admin")
public class CargoController {
	
	@Autowired
	private CargoService cargoService;
	
	@PostMapping("/savecargo")
	public  ResponseEntity<ResponseStructure<Cargo>> saveCargo(@RequestBody Cargo cargo){
		return cargoService.saveCargo(cargo);
	}
	
	@GetMapping("/getallcargo")
	public ResponseEntity<ResponseStructure<List<Cargo>>> getAllCargo(){
		return cargoService.getAllCargo();
	}
	
	@GetMapping("/getcargobyid/{id}")
	public ResponseEntity<ResponseStructure<Cargo>> getCargoById(@PathVariable int id){
		return cargoService.getCargoById(id);
	}

	@PutMapping("/updatecargo/{id}")
	public ResponseEntity<ResponseStructure<Cargo>> updateCargoById(@PathVariable int id,@RequestBody Cargo cargo){
		return cargoService.updateCargo(id, cargo);
	}
	
	@DeleteMapping("/deletecargobyid/{id}")
	public ResponseEntity<ResponseStructure<Cargo>> deleteCargoById(@PathVariable int id){
		return cargoService.deleteCargo(id);
	}
}
