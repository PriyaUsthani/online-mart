package com.example.online_market_project.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.entities.Order_Product;
import com.example.online_market_project.repos.Order_Product_Repo;

@Service
public class Order_Product_Service {

	@Autowired
	private Order_Product_Repo order_product_repo;
	
	@Cacheable(value="order_product",key="#id")
	public Order_Product getOrder_Product_ById(long id) {
		return order_product_repo.findById(id);
	}
	
	public List<Customer> getjoins(){
		return order_product_repo.findCustomerwithOrderProduct();
	}
	
	public List<Object[]> getprice(){
		return order_product_repo.findCustomerIdwithTotalProductPrice();
	}
	
	
}
