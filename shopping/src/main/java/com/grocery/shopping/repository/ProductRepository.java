package com.grocery.shopping.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shopping.entity.Product;


public interface ProductRepository  extends JpaRepository<Product,Integer>{

	
	

}
