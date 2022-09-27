package com.rgt.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rgt.app.models.Address;

public interface AddressRepository extends JpaRepository<Address, Integer>{
	  Address findByEmail(String email);

}
