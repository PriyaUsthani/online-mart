package com.example.online_market_project.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.services.Order_Product_Service;
@RestController
@RequestMapping("/orderproduct")
public class Order_Product_Controller {
	
	@Autowired
	private Order_Product_Service service;
	@GetMapping("/testApi")
	public String get() {
		return "Api work perfectly";
	}
	
	
	@GetMapping("/getjoins")
	public List<Customer> getcustomerwithorderandproducts(){
		return service.getjoins();
	}
	@GetMapping("/gettotalprice")
	public List<Object[]> gettotalprice(){
		return service.getprice();
	}
	
	
}
