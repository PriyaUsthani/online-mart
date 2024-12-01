package com.example.online_market_project.dtos;

import java.util.List;

import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.entities.Order;
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
public class Order_DTO {

	private long customer_id;
    
	private List<Order_Product> order_products;
	
	
}
