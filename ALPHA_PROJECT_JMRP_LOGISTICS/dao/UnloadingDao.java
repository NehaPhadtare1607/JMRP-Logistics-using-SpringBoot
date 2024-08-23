package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Unloading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.UnloadingRepository;

@Repository
public class UnloadingDao {
	@Autowired
	private UnloadingRepository unloadingRepository;
	
	public  Unloading saveUnloading(Unloading unloading) {
		return unloadingRepository.save(unloading);
		
	}
	public List<Unloading> getAllUnloadings() {
		return unloadingRepository.findAll();
	}
	
	public Unloading getUnloadingById(int id) {
		Optional<Unloading> optional= unloadingRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateUnloading(int id, Unloading unloading) {
		 unloadingRepository.save(unloading);
		 return "Unloading records are updated.....";
	}
	
	public String deleteUnloading(int id) {
		Optional<Unloading> optional=unloadingRepository.findById(id);
		if(optional.isPresent()) {
			unloadingRepository.deleteById(id);
			
			return " UnLoading records are deleted.....";
		}
		else {
			return "No records are found in the table......"; 
		}
	}
}
