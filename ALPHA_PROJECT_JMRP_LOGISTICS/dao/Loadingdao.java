package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Loading;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.LoadingRepository;

@Repository
public class Loadingdao {
	@Autowired
	private LoadingRepository loadingRepository;
	
	public Loading saveLoading(Loading loading) {
		return loadingRepository.save(loading);
	}
	
	public List<Loading> getAllLoading() {
		return loadingRepository.findAll();
	}
	public Loading getLoadingById(int id) {
		Optional<Loading> optional = loadingRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
	}
	
	public String updateLoading(int id,Loading loading) {
		 loadingRepository.save(loading);
		 return "Loading records are updated....";
	}
	
	public String deleteLoading(int id) {
		Optional<Loading> optional=loadingRepository.findById(id);
		if(optional.isPresent()) {
			 loadingRepository.deleteById(id);
			 
			 return " Loading records are deleted....";
		}
		else {
			return "no records are found in the table.........";
		}
		
	}

}
