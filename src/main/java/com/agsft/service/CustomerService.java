package com.agsft.service;

import java.util.List;
import java.util.Optional;

import com.agsft.model.Customer;

public interface CustomerService {
	
	public Customer get(int id);
	public List<Customer> getAl();
	public void save(Customer customer);
	public void update(Customer customer);
	public void delete(int id);
	

}
