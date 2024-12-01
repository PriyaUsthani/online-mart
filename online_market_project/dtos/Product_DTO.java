package com.example.online_market_project.dtos;

import com.example.online_market_project.entities.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product_DTO {
	
	private String name;
	private float price;
	private long stock;
	
	public Product to() {
		return Product.builder()
				.name(name)
				.price(price)
				.stock(stock)
				.build();
	}

}
