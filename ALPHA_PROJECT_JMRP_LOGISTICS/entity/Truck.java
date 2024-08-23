package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Truck {
	@Id
	private int id;
	private String name;
	private Long registeredNumber;
	private int capacity;
	private String status;
	private Long carrierId;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getRegisteredNumber() {
		return registeredNumber;
	}
	public void setRegisteredNumber(Long registeredNumber) {
		this.registeredNumber = registeredNumber;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Long getCarrierId() {
		return carrierId;
	}
	public void setCarrierId(Long carrierId) {
		this.carrierId = carrierId;
	}
}
