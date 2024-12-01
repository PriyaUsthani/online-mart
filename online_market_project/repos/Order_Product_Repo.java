package com.example.online_market_project.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.online_market_project.entities.Customer;
import com.example.online_market_project.entities.Order_Product;

@Repository
public interface Order_Product_Repo extends JpaRepository<Order_Product,Long>{

	public Order_Product findById(long id);
	
	@Query("SELECT o.customer FROM Order o JOIN  o.order_products op ON op.order.id=o.id")
	public List<Customer> findCustomerwithOrderProduct();
	
	
	@Query("SELECT o.customer.userName,op.product.name,SUM(op.product.price*op.quantity) FROM Order o JOIN "
			+ "o.order_products op  GROUP BY o.customer.id,op.product.name ORDER BY o.customer.id DESC")
	public List<Object[]> findCustomerIdwithTotalProductPrice();
	
	
    

}
