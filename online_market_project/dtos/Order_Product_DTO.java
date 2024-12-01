package com.example.online_market_project.dtos;

import com.example.online_market_project.entities.Order_Product;

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
public class Order_Product_DTO {

    private String product_name;
	private long quantity;
	
	
}
