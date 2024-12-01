package com.example.online_market_project.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.online_market_project.entities.Customer;

@Repository
public interface Customer_Repo extends JpaRepository<Customer,Long> {

	public Customer findById(long id);
	public Customer findByEmail(String email);
	public Customer findByName(String name);
	
	public void deleteById(long id);
	
	@Modifying
	@Query("UPDATE Customer c set c.email= :email WHERE c.id = :id ")
	public void updateById(@Param("email") String email,@Param("id")long id);
	
	
}


