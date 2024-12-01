package com.example.online_market_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_market_project.dtos.Order_DTO;
import com.example.online_market_project.entities.Order;
import com.example.online_market_project.services.Order_Service;
@RestController
@RequestMapping("/order")
public class Order_Controller {
	
	@Autowired
	private Order_Service service;
	
	
	
	@GetMapping("/testApi")
	public String get() {
		return "Api work perfectly";
	}
	
	@PostMapping("/createOrder")
	public Order createOrder(@RequestBody Order_DTO dto) {
		return service.createOrder(dto);
	}
	
	@GetMapping("getbyid")
	public Order getOrder(@RequestParam(name="id") long id) {
		return service.getOrderById(id);
	}
}
