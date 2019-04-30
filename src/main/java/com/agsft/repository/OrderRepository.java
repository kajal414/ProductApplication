package com.agsft.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.agsft.model.Product;
import com.agsft.model.ProductOrder;

public interface OrderRepository extends CrudRepository<ProductOrder, Integer>{

	/*	String query="select p.id,p.name,p.price from product p,product_order po,customer c where p.id=po.product_id and c.id=:id";
		
		@Query(value=query,nativeQuery=true)
		public List<Product> fibdByCustomerId(@Param("id")int id);*/
}
