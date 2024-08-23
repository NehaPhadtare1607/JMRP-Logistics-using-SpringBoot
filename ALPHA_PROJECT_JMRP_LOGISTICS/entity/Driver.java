package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Driver {
    @Id
    private int id;
    private String driverName;
    private Long driverPhoneNumber;
    private Long truckRegisteredNumber;

    @ManyToOne
    @JoinColumn
    private Carriers carriers;

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public Long getDriverPhoneNumber() {
        return driverPhoneNumber;
    }

    public void setDriverPhoneNumber(Long driverPhoneNumber) {
        this.driverPhoneNumber = driverPhoneNumber;
    }

    public Long getTruckRegisteredNumber() {
        return truckRegisteredNumber;
    }

    public void setTruckRegisteredNumber(Long truckRegisteredNumber) {
        this.truckRegisteredNumber = truckRegisteredNumber;
    }

    public Carriers getCarriers() {
        return carriers;
    }

    public void setCarriers(Carriers carriers) {
        this.carriers = carriers;
    }
}
