package com.agsft.service.Impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.agsft.model.Customer;
import com.agsft.model.Product;
import com.agsft.model.ProductOrder;
import com.agsft.repository.CustomerRepository;
import com.agsft.repository.OrderRepository;
import com.agsft.repository.ProductRepository;
import com.agsft.service.ProductOrderService;
import com.agsft.service.dto.OrderDTO;

@Service
public class OrderServiceImpl implements ProductOrderService {

	@Autowired
	OrderRepository orderRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ProductRepository productRepo;

	@Override
	public ProductOrder get(int id) {
		return orderRepo.findById(id).get();
	}

	@Override
	public List<ProductOrder> getAll() {
		List<ProductOrder> list = new ArrayList<>();
		orderRepo.findAll().forEach(list::add);
		return list;
	}

	@Override
	public void save(ProductOrder order) {
		orderRepo.save(order);

	}

	@Override
	public void update(ProductOrder order) {
		orderRepo.save(order);

	}

	@Override
	public void delete(int id) {
		orderRepo.deleteById(id);
	}

	@Override
	public void placeOrder(OrderDTO orderDto) {
		int totalPrice = 0;
		Optional<Customer> customerFetch = customerRepo.findById(orderDto.getCustomerId());

		if (!customerFetch.isPresent()) {
			throw new RuntimeException("Customer Not found ......");
		}

		List<Product> productsFetch = (List<Product>) productRepo.findAllById(orderDto.getProducts());

		if (productsFetch.isEmpty() || orderDto.getProducts().size() != productsFetch.size()) {
			throw new RuntimeException("product NOT FOUND............");
		}

		for (Product product1 : productsFetch) {
			totalPrice += product1.getPrice();
		}

		ProductOrder productOrder = new ProductOrder();

		productOrder.setCustomer(customerFetch.get());
		productOrder.setQuantity(productsFetch.size());
		productOrder.setTotal(totalPrice);
		productOrder.setProducts(productsFetch);

		orderRepo.save(productOrder);

	}

}
