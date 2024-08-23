package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity;

import java.sql.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class Orders {
    @Id
    private int id;
    private Date dateOfOrder;
    private String orderStatus;
    private double freightCost;
    private String additionalInfo;

    @ManyToOne
    private Carriers carriers;

    @OneToOne
    private Cargo cargo;

    @OneToOne
    private Loading loading;

    @OneToOne
    private Unloading unloading;

    @ManyToMany
    private List<Users> loadingUser; // Changed to List<Users>

    @ManyToMany
    private List<Users> unloadUser; // Changed to List<Users>

    // Getters and Setters
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDateOfOrder() {
        return dateOfOrder;
    }

    public void setDateOfOrder(Date dateOfOrder) {
        this.dateOfOrder = dateOfOrder;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public double getFreightCost() {
        return freightCost;
    }

    public void setFreightCost(double freightCost) {
        this.freightCost = freightCost;
    }

    public String getAdditionalInfo() {
        return additionalInfo;
    }

    public void setAdditionalInfo(String additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public Carriers getCarrier() {
        return carriers;
    }

    public void setCarrier(Carriers carriers) {
        this.carriers = carriers;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Loading getLoading() {
        return loading;
    }

    public void setLoading(Loading loading) {
        this.loading = loading;
    }

    public Unloading getUnloading() {
        return unloading;
    }

    public void setUnloading(Unloading unloading) {
        this.unloading = unloading;
    }

    public List<Users> getLoadingUser() {
        return loadingUser;
    }

    public void setLoadingUser(List<Users> loadingUser) {
        this.loadingUser = loadingUser;
    }

    public List<Users> getUnloadUser() {
        return unloadUser;
    }

    public void setUnloadUser(List<Users> unloadUser) {
        this.unloadUser = unloadUser;
    }
}
