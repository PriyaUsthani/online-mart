package com.example.online_market_project.controllers;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.online_market_project.dtos.Customer_DTO;
import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.services.Customer_Service;

@RestController
@RequestMapping("/user")
public class Customer_Controller {
	
	@Autowired
	private Customer_Service service;

	@GetMapping("/testApi")
	public String get() {
		return "Api work perfectly";
	}
	
	@PutMapping("/update/{email}")
	public void update(@PathVariable String email,@RequestParam(name="id") long id) {
		
		 service.updateCustomerById(email,id);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> delete(@PathVariable long id) {
		service.deleteCustomerByid(id);
		return  ResponseEntity.noContent().build();//204 no content response
	}
	
	@PostMapping("/create")
	public ResponseEntity<Customer> createCustomer(@RequestBody Customer_DTO dto) {
		Customer saved= service.createCustomer(dto);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved);//201 code
	}

	@GetMapping("/getbyid")
	public ResponseEntity<Customer> getCustomer(@RequestParam(name="id")long id) {
		Optional<Customer> saved = Optional.ofNullable(service.getCustomerById(id));
		if(saved.isPresent()) {
			return ResponseEntity.ok(saved.get());
		}
		else {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}

	
	@GetMapping("/getbyname")
	public ResponseEntity<Customer> getByName(@RequestParam(name="name") String name){
		Optional<Customer> customer = Optional.ofNullable(service.getCustomerByName(name));
		if(customer.isPresent()) {
			return ResponseEntity.ok(customer.get());
		}
		else {
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
	}
}
