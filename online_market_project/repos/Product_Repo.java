package com.example.online_market_project.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.online_market_project.entities.Product;

@Repository
public interface Product_Repo extends JpaRepository<Product,Long> {
	
	public Product findById(long id);
	public Product findByName(String name);
	
	
	@Modifying
	@Query("UPDATE Product p set p.price=:price WHERE p.name=:name")
	public void updatePriceByProductname(@Param("price")float price,@Param("name")String name);
	
	@Modifying
	@Query("UPDATE Product p set p.stock=:stock WHERE p.name=:name")
	public void updateStockByProductname(@Param("stock")long stock,@Param("name")String product_name);
	
	public void deleteProductById(long id);
	
}

