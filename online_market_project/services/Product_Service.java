package com.example.online_market_project.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.online_market_project.dtos.Product_DTO;
import com.example.online_market_project.entities.Product;
import com.example.online_market_project.repos.Product_Repo;

@Service
public class Product_Service {

	@Autowired
	private Product_Repo product_repo;
	
	public Product createProduct(Product_DTO pdt) {
		Product product = pdt.to();
		return product_repo.save(product);
	}
	
	@Cacheable(value="product",key="#id")
	public Product getProductById(long id) {
		return product_repo.findById(id);
	}
	
	@Transactional
	@CachePut(value="product",key="#name")
	public void updatePriceByName(float price,String name) {
		product_repo.updatePriceByProductname(price,name);
		
	}
	@Transactional
	@CachePut(value="product",key="#name")
	public void updateStockByName(long stock,String name) {
		product_repo.updateStockByProductname(stock,name);
		
	}
	
	@Transactional
	@CacheEvict(value="product",key="#id")
	public void deleteProduct(long id ) {
		product_repo.deleteProductById(id);
		
	}
	
}
