package com.rgt.app.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import org.springframework.format.annotation.DateTimeFormat;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	
	private int billNumber;
	private String firstName;
	private String lastName;
	private String Address;
	private long phoneNumber;
	private String email;
	
	private long cardNumber;
	@DateTimeFormat(pattern = "MM/yy")
	private Date monthAndYear;
	
	private int cvvCode;
	private String cardName;
	private double total;
	
	
	
}
