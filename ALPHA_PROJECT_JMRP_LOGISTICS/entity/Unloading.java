package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import java.sql.Date;
import java.sql.Time;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Unloading {
	@Id
	private int id;
	private String companyName;
	private Date unloadingdate;
	private Time unloadingTime;
	
	@OneToOne
	private Address address;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public Date getUnloadingdate() {
		return unloadingdate;
	}

	public void setUnloadingdate(Date unloadingdate) {
		this.unloadingdate = unloadingdate;
	}

	public Time getUnloadingTime() {
		return unloadingTime;
	}

	public void setUnloadingTime(Time unloadingTime) {
		this.unloadingTime = unloadingTime;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	

}
