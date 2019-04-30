package com.agsft.service.dto;

import java.util.List;

import com.agsft.model.Product;

public class OrderDTO {
	
	private Integer customerId;
	
	private List<Integer> products;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}

	public List<Integer> getProducts() {
		return products;
	}

	public void setProducts(List<Integer> products) {
		this.products = products;
	}
	
	  
	
	

}
