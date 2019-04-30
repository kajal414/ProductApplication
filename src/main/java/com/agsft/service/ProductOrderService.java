package com.agsft.service;

import java.util.List;

import com.agsft.model.ProductOrder;
import com.agsft.service.dto.OrderDTO;

public interface ProductOrderService {

	public ProductOrder get(int id);
	public List<ProductOrder> getAll();
	public void save(ProductOrder order);
	public void update(ProductOrder order);
	public void delete(int id);
	public void placeOrder(OrderDTO orderDto);
	
}
