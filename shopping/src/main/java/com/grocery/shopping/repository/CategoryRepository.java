package com.grocery.shopping.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.grocery.shopping.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category,Long>{

}
