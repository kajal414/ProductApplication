package com.agsft.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.agsft.model.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

	
}
