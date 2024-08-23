package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Cargo {
	@Id
	private int id;
	private String cargoName;
	private String cargoDescription;
	private double cargoWeight;
	private int cargoCount;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCargoName() {
		return cargoName;
	}
	public void setCargoName(String cargoName) {
		this.cargoName = cargoName;
	}
	public String getCargoDescription() {
		return cargoDescription;
	}
	public void setCargoDescription(String cargoDescription) {
		this.cargoDescription = cargoDescription;
	}
	public double getCargoWeight() {
		return cargoWeight;
	}
	public void setCargoWeight(double cargoWeight) {
		this.cargoWeight = cargoWeight;
	}
	public int getCargoCount() {
		return cargoCount;
	}
	public void setCargoCount(int cargoCount) {
		this.cargoCount = cargoCount;
	}
	
	

}
