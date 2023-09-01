package com.grocery.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocery.shopping.entity.Product;
import com.grocery.shopping.repository.ProductRepository;

@Service
public class ProductServiceImplement implements ProductService {

	@Autowired

	private ProductRepository productrepository;

	@Override
	public Product getProduct(int id) {
		Optional<Product> optional=productrepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}


	@Override

	public Product create(Product product) {
	    return productrepository.save(product);
		 
		}



	@Override
	public List<Product> getAllProduct(){
		return productrepository.findAll();
	}


	@Override
	public void updateProduct(Product product) {
		productrepository.save(product);
		
	}


	@Override
	public void deleteProduct(int id) {
		Optional<Product> optional = productrepository.findById(id);
		if(!optional.isEmpty()) {
		  productrepository.delete(optional.get());
		}
	}
	@Override
	 public void deleteProductById(int productId) {
	        productrepository.deleteById(productId);
	    }
	}