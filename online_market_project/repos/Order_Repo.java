package com.example.online_market_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.online_market_project.entities.Order;

@Repository
public interface Order_Repo extends JpaRepository<Order,Long> {
	
	public Order findById(long id);
	
	
}
