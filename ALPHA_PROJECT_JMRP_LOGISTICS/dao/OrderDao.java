package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Orders;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.repository.OrderRepository;

@Repository
public class OrderDao {
	@Autowired
	private OrderRepository orderRepository;
	
	public Orders saveOrder(Orders order) {
		return orderRepository.save(order);
	}
	
	public List<Orders> getAllOrders() {
		return orderRepository.findAll();
		
	}
	public Orders getOrderById(int id) {
		Optional<Orders> optional=orderRepository.findById(id);
		if(optional.isPresent()) {
			return optional.get(); 
		}
		else {
			return null;
		}
	}
	
	public String updateOrder(int id,Orders order) {
		 orderRepository.save(order);
		 return "Order is updated....";
	}
	
	public String deleteOrder(int id) {
		Optional<Orders> optional=orderRepository.findById(id);
		if(optional.isPresent()) {
			orderRepository.deleteById(id);
			return "Order records are deleted......";
		}
		else {
			return "No records are found in the table.....";
		}
	}

}
