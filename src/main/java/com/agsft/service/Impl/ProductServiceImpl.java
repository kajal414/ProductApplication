package com.agsft.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.model.Product;
import com.agsft.repository.ProductRepository;
import com.agsft.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{

	@Autowired 
	ProductRepository repository;
	
	@Override
	public Product get(int id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Product> getAll() {
		List<Product> list=new ArrayList<>();
		repository.findAll().forEach(list::add);
		return list;
	}

	@Override
	public void save(Product product) {
		repository.save(product);
		
	}

	@Override
	public void update(Product product) {
		repository.save(product);
		
	}

	@Override
	public void delete(int id) {
		repository.deleteById(id);
		
	}

	public int getPriceOfProduct(int id) {
		return repository.findById(id).get().getPrice();
	
	}
	

	
}
