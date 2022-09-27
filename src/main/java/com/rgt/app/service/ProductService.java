 package com.rgt.app.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rgt.app.models.Product;
import com.rgt.app.repository.ProductReposiory;

@Service
public class ProductService {      
	 
	@Autowired
	private ProductReposiory productReposiory;
	 
	public List<Product>getallProducts(){  
		return productReposiory.findAll();
	}
	
	public void addProduct(Product product) {
		productReposiory.save(product);
		
	}
	public void removeProductById(int id) {
		productReposiory.deleteById(id);
	}
	public Optional<Product> getProductById(int id){
		return productReposiory.findById(id);
	}
	public List<Product>getAllProductsByCategoryById(int id){
		return productReposiory.findAllByCategory_Id(id);
		
	}

}
