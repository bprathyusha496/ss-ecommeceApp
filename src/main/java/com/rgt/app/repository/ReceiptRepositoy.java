package com.rgt.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rgt.app.models.Receipt;

@Repository
public interface ReceiptRepositoy extends JpaRepository<Receipt, Integer> {

	
	  
	  public void save(int id);

	public String getByEmail(String email);

	
	 
}
