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
import com.agsft.service.Impl.ProductServiceImpl;

@RestController
public class ProductController {

	@Autowired
	ProductServiceImpl service;
	
	@GetMapping("/getProduct/{id}")
	public Product getProductByID(@PathVariable int id) {
		return service.get(id);
	}
	
	@GetMapping("/getAllProduct")
	public List<Product> getAll(){
		return service.getAll();
	}
	
	@PostMapping("/saveProduct")
	public ResponseEntity<String> save(@RequestBody Product product){
		 service.save(product);
		return new ResponseEntity<String>("Resource created successfuly",HttpStatus.CREATED);
	}
	
	@PutMapping("/updateProduct")
	public ResponseEntity<String> update(@RequestBody Product product){
		service.update(product);
		return new ResponseEntity<String>("Resource updated Successfuly",HttpStatus.OK);
	}
	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<String> delete(@PathVariable int id){
		service.delete(id);
		return new ResponseEntity<String>("Resource deleted Successfuly",HttpStatus.OK);
	}
}
