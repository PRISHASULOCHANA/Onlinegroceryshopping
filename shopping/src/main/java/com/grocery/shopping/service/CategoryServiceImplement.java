package com.grocery.shopping.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.grocery.shopping.entity.Category;
import com.grocery.shopping.repository.CategoryRepository;

@Service
public class CategoryServiceImplement implements CategoryService{

	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public Category getCategory(long id) {
		Optional<Category> optional=categoryRepository.findById(id);
		if(optional.isEmpty()) {
			return null;
		}
		return optional.get();
	}
	
	@Override
	public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }
	
	@Override
	public Optional<Category> getCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId);
    }
	

	@Override
	public Category create(Category category) {
	    return categoryRepository.save(category);
		 
		}
	@Override
	 public Page<Category> getCategoryByField(int pageNo, int pageSize,String field) {
		Sort sort= Sort.by(field);
	        Pageable pageable = PageRequest.of(pageNo, pageSize, sort);
	        return categoryRepository.findAll(pageable);
	    }


}