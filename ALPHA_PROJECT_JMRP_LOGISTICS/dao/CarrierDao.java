package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Carriers;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.CarrierRepository;

@Repository
public class CarrierDao {
	
	@Autowired
	private CarrierRepository carrierRepository;
	
	public Carriers saveCarrier(Carriers carrier) {
		return carrierRepository.save(carrier);	
	}
	
	public List<Carriers> getAllCarriers(){
		List<Carriers> carrier=carrierRepository.findAll();
		return carrier;
	}
	
	public Carriers  getCarrierById(int id) {
		Optional<Carriers>optional=carrierRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateCarrier(Carriers carrier) {
		 carrierRepository.save(carrier);
		 return "Carrier records are updated...";
	}
	
	public String deleteCarrierById(int id) {
		Optional<Carriers> optional=carrierRepository.findById(id);
		if(optional.isPresent()) {
			carrierRepository.deleteById(id);
			return "Carrier record is deleted...";
		}
		else {
			return "no records are found in the table";
		}
	}

}
