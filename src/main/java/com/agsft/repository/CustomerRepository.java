package com.agsft.repository;

import org.springframework.data.repository.CrudRepository;

import com.agsft.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer,Integer>{

}
