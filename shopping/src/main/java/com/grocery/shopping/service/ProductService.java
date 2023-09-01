package com.grocery.shopping.service;

import java.util.List;

import com.grocery.shopping.entity.Product;

public interface ProductService {

	Product getProduct(int id);


	List<Product> getAllProduct();

	void updateProduct(Product product);

	void deleteProduct(int id);

	Product create(Product product);


	void deleteProductById(int productId);


	
}
