 package com.rgt.app.models;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;
@Entity
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Column(name = "product_id")
	private int id;
	private String name;
	@JsonIgnore
	@ManyToOne(fetch =FetchType.LAZY)
	@JoinColumn(name = "category_id",referencedColumnName = "category_id")
	private Category category;
	private double price;
	private double weight;
	private String description;
	private String imageName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user")
	private User user;
	
	
	public Product() {
		
		super();  
	}
	
	public Product(int id, String name, Category category, double price, double weight, String description,
			String imageName) {
		super();
		this.id = id;
		this.name = name;
		this.category = category;
		this.price = price;
		this.weight = weight;
		this.description = description;
		this.imageName = imageName;
	}

	public Product(int i) {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	public double getPrice() {
		return price;
	} 
	public void setPrice(double price) {
		this.price = price;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageName() {
		return imageName;
	}
	public void setImageName(String imageName) {
		this.imageName = imageName;
	}
	
	
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	

	
	
	
}
