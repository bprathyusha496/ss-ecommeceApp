package com.rgt.app.repository;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rgt.app.models.Receipt;

@Repository
public interface ReceiptRepositoy extends JpaRepository<Receipt, Integer> {

	
	  
	  public void save(int id);

	public String getByEmail(String email);

	
	 
}
