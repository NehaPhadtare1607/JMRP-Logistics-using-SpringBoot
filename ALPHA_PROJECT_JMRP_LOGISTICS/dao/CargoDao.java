package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Cargo;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.CargoRepository;

@Repository
public class CargoDao {
	
	@Autowired
	private CargoRepository cargoRepository;
	
	
	public Cargo saveCargo(Cargo cargo) {
		return cargoRepository.save(cargo);
	}
	
	public List<Cargo> getAllCargo() {
		List<Cargo> cargo= cargoRepository.findAll();
		return cargo;
	}
	
	public Cargo getCargoById(int id) {
		Optional<Cargo> optional=cargoRepository.findById(id);
		if(optional.isPresent()) {
		return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateCargo(Cargo cargo) {
		cargoRepository.save(cargo);
		return "cargo data is updated...";
	}
	
	public String deleteCargoById(int id) {
		Optional<Cargo> optional=cargoRepository.findById(id);
		if(optional.isPresent()) {
			cargoRepository.deleteById(id);
			return "cargo record is deleted...";
		}
		else {
			return "no records are found in the table....";
		}
	}
	

}
