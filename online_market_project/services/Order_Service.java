package com.example.online_market_project.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.online_market_project.dtos.Order_DTO;
import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.entities.Order;
import com.example.online_market_project.entities.Order_Product;
import com.example.online_market_project.entities.Product;
import com.example.online_market_project.repos.Customer_Repo;
import com.example.online_market_project.repos.Order_Repo;
import com.example.online_market_project.repos.Product_Repo;

@Service
public class Order_Service {
       
	@Autowired
	private Order_Repo order_repo;
	
	@Autowired
	private Customer_Repo customer_repo;
	
	@Autowired
	private Product_Repo product_repo;
	
	
	public Order createOrder(Order_DTO order_dto) {
		
		Customer customer = customer_repo.findById(order_dto.getCustomer_id());
		Order order= new Order();
		order.setCustomer(customer);
		
		Order saveOrder  = order_repo.save(order);
		List<Order_Product> order_product= order_dto.getOrder_products().stream()
				.map(Order_Product_DTO ->{
					Order_Product o= new Order_Product();
					o.setOrder(order);
					o.setProduct_name(Order_Product_DTO.getProduct_name());
					o.setQuantity(Order_Product_DTO.getQuantity());
					Product product = product_repo.findByName(Order_Product_DTO.getProduct_name());
					o.setProduct(product);
					
					return o;
					
				}).collect(Collectors.toList());
		
		saveOrder.setOrder_products(order_product);
		return order_repo.save(saveOrder);
	}
	
	
	public Order getOrderById(long id) {
		return order_repo.findById(id);
	}
}
