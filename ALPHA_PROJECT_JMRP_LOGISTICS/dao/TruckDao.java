package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Truck;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.TruckRepository;

@Repository
public class TruckDao {
	
	@Autowired
	private TruckRepository truckRepository;
	
	public Truck saveTruck(Truck truck) {
		return truckRepository.save(truck);	
	}
	
	public List<Truck> getAllTrucks(){
		List<Truck> truck=truckRepository.findAll();
		return truck;
	}
	
	public Truck  getTruckById(int id) {
		Optional<Truck>optional=truckRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateTruck(Truck truck) {
		 truckRepository.save(truck);
		 return "Truck records are updated...";
	}
	
	public String deleteTruckById(int id) {
		Optional<Truck> optional=truckRepository.findById(id);
		if(optional.isPresent()) {
			truckRepository.deleteById(id);
			return "Truck record is deleted...";
		}
		else {
			return "no records are found in the table";
		}
	}
	
	

}
