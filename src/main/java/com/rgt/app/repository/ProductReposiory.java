package com.rgt.app.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgt.app.models.Product;
import com.rgt.app.models.User;

public interface ProductReposiory extends JpaRepository<Product, Integer>{

	List<Product> findAllByCategory_Id(int id);

	void save(User obj);

}
