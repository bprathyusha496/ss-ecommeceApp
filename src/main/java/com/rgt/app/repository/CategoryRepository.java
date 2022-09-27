package com.rgt.app.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgt.app.models.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

	Optional<Category> findById(Category categoryId);

}
