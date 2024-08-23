package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dao.OrderDao;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Orders;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.exception.IdNotFoundException;

@Service
public class OrderService {
	
	@Autowired
	private OrderDao orderdao;
	
	public ResponseEntity<ResponseStructure<Orders>> saveOrder(Orders order){
		Orders receivedOrders=orderdao.saveOrder(order);
		
		ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(receivedOrders);
		
		return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.OK);
	}
	
	
	public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
		List<Orders> order=orderdao.getAllOrders();
		
		ResponseStructure<List<Orders>> responseStructure=new ResponseStructure<List<Orders>>();
		
		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Success");
		responseStructure.setData(order);
		
		return new ResponseEntity<ResponseStructure<List<Orders>>>(responseStructure,HttpStatus.CREATED);
	}
	
	public ResponseEntity<ResponseStructure<Orders>> getOrdersById(int id){
		Orders order=orderdao.getOrderById(id);
		if(order!=null) {
			ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			responseStructure.setStatusCode(HttpStatus.CREATED.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(order);
			
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID :" +id+ " is not present in the database.........");
		}
	}
	
	public ResponseEntity<ResponseStructure<Orders>> updateOrders(int id,Orders updatedorder){
		Orders existingOrders=orderdao.getOrderById(id);
		
		if(existingOrders!=null) {
			existingOrders.setOrderStatus(updatedorder.getOrderStatus());
			existingOrders.setDateOfOrder(updatedorder.getDateOfOrder());
			existingOrders.setFreightCost(updatedorder.getFreightCost());
			
			Orders saveOrders=orderdao.saveOrder(existingOrders);
			ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(updatedorder);
			
			return new ResponseEntity<ResponseStructure<Orders>>(responseStructure,HttpStatus.OK);	
		}
		else {
			throw new IdNotFoundException("Id" +id+ " is not found in the database");
		}
	}
	
	public ResponseEntity<ResponseStructure<Orders>> deleteOrderById(int id){
		
		Orders order=orderdao.getOrderById(id);
		if(order!=null) {
			orderdao.deleteOrder(id);
			
			ResponseStructure<Orders> responseStructure=new ResponseStructure<Orders>();
			responseStructure.setStatusCode(HttpStatus.OK.value());
			responseStructure.setMessage("Success");
			responseStructure.setData(order);

			return new ResponseEntity<ResponseStructure<Orders>>(HttpStatus.OK);
		}
		else {
			throw new IdNotFoundException("ID" +id+ " is not found....");
		}
	}
	
	

}
