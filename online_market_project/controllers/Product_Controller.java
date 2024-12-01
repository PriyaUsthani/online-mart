package com.example.online_market_project.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_market_project.dtos.Product_DTO;
import com.example.online_market_project.entities.Product;
import com.example.online_market_project.services.Product_Service;
@RestController
@RequestMapping("/admin")
public class Product_Controller {
	
	@Autowired
	private Product_Service service;
	
	@GetMapping("/testApi")
	public String get() {
		return "Api work perfectly";
	}
	
	@PostMapping("/create")
	public Product createProduct(@RequestBody Product_DTO dto) {
		return service.createProduct(dto);
	}
	@GetMapping("/getbyid")
	public Product getProduct(@RequestParam(name="id")long id) {
		return service.getProductById(id);
	}
	
	@PutMapping("/updatePrice/{price}")
	public void updatePrice(@PathVariable(name="price") float price,@RequestParam(name="name") String name) {
		service.updatePriceByName(price,name);
	}
	
	@PutMapping("/updateStock/{stock}")
	public void updateStock(@RequestParam(name="stock") long stock,@PathVariable String name) {
		service.updateStockByName(stock,name);
	}
}
