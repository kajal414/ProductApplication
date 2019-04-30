	package com.agsft.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.model.Customer;
import com.agsft.repository.CustomerRepository;
import com.agsft.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	CustomerRepository repository;
		
	@Override
	public Customer get(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Customer> getAl() {
		List<Customer> list=new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public void save(Customer customer) {
		repository.save(customer);
	}

	@Override
	public void update(Customer customer) {
		repository.save(customer);
		
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}
	

}
