package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Orders;



public interface OrderRepository extends JpaRepository<Orders, Integer> {

}
