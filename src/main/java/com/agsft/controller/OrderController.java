package com.agsft.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.agsft.model.Product;
import com.agsft.model.ProductOrder;
import com.agsft.service.Impl.OrderServiceImpl;
import com.agsft.service.dto.OrderDTO;

@RestController
public class OrderController {

	@Autowired
	OrderServiceImpl service;
	
	@GetMapping("/get/{id}")
	public ProductOrder get(@PathVariable int id) {
		return service.get(id);
	}
	
	@GetMapping("/getAllOrders")
	public List<ProductOrder> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/saveOrder")
	public ResponseEntity<String> save(@RequestBody ProductOrder order){
		service.save(order);
		return new ResponseEntity<String>("Resource created successfully",HttpStatus.CREATED);
	}
	
	@PutMapping("/updateOrder")
	public ResponseEntity<String> update(@RequestBody ProductOrder order){
		service.update(order);
		return new ResponseEntity<String>("Resource Updated Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteOrder/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<String>("Resource deleted Successfuly",HttpStatus.OK);
	}
	
	
	@PostMapping("/placeOrder")
	public ResponseEntity<String> placeOrder(@RequestBody OrderDTO orderDto){
		service.placeOrder(orderDto);
		return new ResponseEntity<String>("Resource created Successfuly",HttpStatus.OK);
	}
}