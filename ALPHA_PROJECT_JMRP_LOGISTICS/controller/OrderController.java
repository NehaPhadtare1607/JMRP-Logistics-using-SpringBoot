package com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.controller;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.dto.ResponseStructure;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.entity.Orders;
import com.ty.ALPHA_PROJECT_JMRP_LOGISTICS.service.OrderService;

@RestController
@RequestMapping("api/admin/orders")
public class OrderController {
	
    @Autowired
    private OrderService orderService;
    
    @PostMapping("/save")
    public ResponseEntity<ResponseStructure<Orders>> saveOrder(@RequestBody Orders order){
        return orderService.saveOrder(order); 
    }
    
    @GetMapping("/all")
    public ResponseEntity<ResponseStructure<List<Orders>>> getAllOrders(){
        return orderService.getAllOrders();
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ResponseStructure<Orders>> getOrderById(@PathVariable int id){
        return orderService.getOrdersById(id);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseStructure<Orders>> updateOrder(@PathVariable int id,@RequestBody Orders order){
        return orderService.updateOrders(id, order);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseStructure<Orders>> deleteOrder(@PathVariable int id){
        return orderService.deleteOrderById(id);
    }
}
