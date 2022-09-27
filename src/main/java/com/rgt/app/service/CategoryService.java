package com.rgt.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgt.app.models.Category;
import com.rgt.app.repository.CategoryRepository;

@Service
public class CategoryService {  
	@Autowired 
	CategoryRepository categoryRepository;
	
	public List<Category>getallCategory(){
		return categoryRepository.findAll();
	}
	
	public Category addCategory(Category category) {
		return categoryRepository.save(category);
		
	}
	public void removeCategoryById(int id) {
		 categoryRepository.deleteById(id);
	}

	public Optional<Category> getCategoryById(int id) {
		
		return categoryRepository.findById(id);
	}

}
