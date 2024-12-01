package com.example.online_market_project.services;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.online_market_project.dtos.Customer_DTO;
import com.example.online_market_project.entities.Customer;

import com.example.online_market_project.repos.Customer_Repo;


import jakarta.transaction.Transactional;

@Service
public class Customer_Service {

	@Autowired
	private PasswordEncoder passwordEncoder;
	@Autowired
	private Customer_Repo customer_repo;
	

	
	public Customer createCustomer(Customer_DTO dto) {
		Customer customer = new Customer();
		customer.setName(dto.getName());
		customer.setEmail(dto.getEmail());

		return customer_repo.save(customer);	
	}
	
	@Cacheable(value="customers",key="#name")
	public Customer getCustomerByName(String name ) {
		return customer_repo.findByName(name);
	}
	@Cacheable(value="customers",key="#id")
	public Customer getCustomerById(long id) {
		return customer_repo.findById(id);
	}
	
	@Transactional
	@CachePut(value="customers",key="#id")
	public void updateCustomerById(String email,long id) {
	 customer_repo.updateById(email,id);
	 
	}
	
	@Transactional
	@CacheEvict(value="customers",key="#id")
	public void deleteCustomerByid(long id){
		 customer_repo.deleteById(id);
	}
	
	

	
	
}
