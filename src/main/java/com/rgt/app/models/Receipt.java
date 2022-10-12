package com.rgt.app.models;

import java.time.LocalDateTime;

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
public class Receipt {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int receiptid;
	private int ProductId;
	private String name;	
	private String category;
	private double price;
	private double weight;
	private String description;
	private String imageName;
	private String email;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime OrderDate; 
	private String Confirm;
	private	int user;
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private LocalDateTime DeliveredDate; 
	private int statusId;
	
	
	
}
