package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Carriers {
    @Id
    private int id;
    private String carrierCompanyName;
    private Long carrierContact;
    private String carrierEmail;

    @OneToMany(mappedBy = "carriers")
    private List<Driver> drivers; // Corrected to List<Driver>

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarrierCompanyName() {
        return carrierCompanyName;
    }

    public void setCarrierCompanyName(String carrierCompanyName) {
        this.carrierCompanyName = carrierCompanyName;
    }

    public Long getCarrierContact() {
        return carrierContact;
    }

    public void setCarrierContact(Long carrierContact) {
        this.carrierContact = carrierContact;
    }

    public String getCarrierEmail() {
        return carrierEmail;
    }

    public void setCarrierEmail(String carrierEmail) {
        this.carrierEmail = carrierEmail;
    }

    public List<Driver> getDrivers() {
        return drivers;
    }

    public void setDrivers(List<Driver> drivers) {
        this.drivers = drivers;
    }
}
