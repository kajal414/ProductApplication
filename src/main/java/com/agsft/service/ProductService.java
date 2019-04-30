package com.agsft.service;

import java.util.List;

import com.agsft.model.Product;

public interface ProductService {
	
	public Product get(int id);
	public List<Product> getAll();
	public void save(Product product);
	public void update(Product product);
	public void delete(int id);

}
