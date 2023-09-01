package com.grocery.shopping.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;



@Entity
@Table(name="categories")
public class Category {
	@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private long id;
		private String name;
		private String description;
		
		
		@OneToMany(cascade =CascadeType.ALL)
		@JoinColumn(name="product_id")
		 private List<Product>products;
		
		public List<Product> getProducts() {
			return products;
		}
		public void setProducts(List<Product> products) {
			this.products = products;
		}
		
		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public Category() {
			super();
		}

		public Category(long id, String name, String description) {
			super();
			this.id = id;
			this.name = name;
			this.description = description;
		}
		
		
		
	}

