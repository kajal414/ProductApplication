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

import com.agsft.model.Customer;
import com.agsft.service.Impl.CustomerServiceImpl;

@RestController
public class CustomerController {
	
	@Autowired
	CustomerServiceImpl service;
	
	@GetMapping("/getCustomer/{id}")
	public Customer get(@PathVariable int id) {
		return service.get(id);
	}

	@GetMapping("/getAllCustomer")
	public List<Customer> getAll(){
		return service.getAl();
	}
	
	@PostMapping("/saveCustomer")
	public ResponseEntity<String> save(@RequestBody Customer customer){
		 service.save(customer);
		 return new ResponseEntity<String>("Resource Successfuly created",HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomer")
	public ResponseEntity<String> update(@RequestBody Customer customer){
		service.update(customer);
		return new ResponseEntity<String>("Resource updated Successfully",HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustome/{id}")
	public ResponseEntity<String> delete(@PathVariable int id) {
		service.delete(id);
		return new ResponseEntity<String>("Resource deleted Successfuly",HttpStatus.OK);
		
	}
}
