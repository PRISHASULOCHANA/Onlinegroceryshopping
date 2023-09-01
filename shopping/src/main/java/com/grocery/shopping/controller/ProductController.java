package com.grocery.shopping.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.shopping.entity.Product;
import com.grocery.shopping.service.ProductService;

@RestController
public class ProductController {

	@Autowired
	public ProductService productService;
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getProduct(@PathVariable int id) {
		Product product = productService.getProduct(id);
		if (product == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	
	@PostMapping("/product")
	public Product addProduct(@RequestBody Product product) {
		return productService.create(product);
	}
	
	
	@GetMapping("/product")
	public ResponseEntity<List<Product>> getAllProducts(){
		List<Product> product = productService.getAllProduct();
		return ResponseEntity.status(HttpStatus.OK).body(product);
	}
	
	
	@PutMapping("/product")
	public ResponseEntity<String> updateProduct(@RequestBody Product product) {
		productService.updateProduct(product);
		return ResponseEntity.ok("Updated");
	}
	
	
	@DeleteMapping("/product")
	public ResponseEntity<String> deleteProduct(@RequestBody Product product) {
		productService.deleteProduct(product.getId());
		return ResponseEntity.ok("Deleted");
	}
	@DeleteMapping("/product/{productId}")
    public ResponseEntity<String> deleteProductById(@PathVariable int productId) {
        productService.deleteProductById(productId);
        return new ResponseEntity<>("Product deleted successfully", HttpStatus.OK);
    }
	Logger logger = LoggerFactory.getLogger(ProductController.class);
	@GetMapping(path="/loggerdemo")
		public String loggerDemo() {
			logger.info("Logger info");
			logger.warn("Logger warn");
			logger.error("logger error");
			return "Hello from logger demo";
		}
}

