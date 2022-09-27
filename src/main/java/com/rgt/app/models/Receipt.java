package com.rgt.app.models;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

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
	
	public int getReceiptid() {
		return receiptid;
	}
	public void setReceiptid(int receiptid) {
		this.receiptid = receiptid;
	}
	public int getProductId() {
		return ProductId;
	}
	public void setProductId(int productId) {
		ProductId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getConfirm() {
		return Confirm;
	}
	public void setConfirm(String confirm) {
		Confirm = confirm;
	}
	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	
	public LocalDateTime getOrderDate() {
		return OrderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		OrderDate = orderDate;
	}
	public LocalDateTime getDeliveredDate() {
		return DeliveredDate;
	}
	public void setDeliveredDate(LocalDateTime deliveredDate) {
		DeliveredDate = deliveredDate;
	}
	public int getStatusId() {
		return statusId;
	}
	public void setStatusId(int statusId) {
		this.statusId = statusId;
	}
	@Override
	public String toString() {
		return "Receipt [receiptid=" + receiptid + ", ProductId=" + ProductId + ", name=" + name + ", category="
				+ category + ", price=" + price + ", weight=" + weight + ", description=" + description + ", imageName="
				+ imageName + ", email=" + email + ", OrderDate=" + OrderDate + ", Confirm=" + Confirm + ", user="
				+ user + ", DeliveredDate=" + DeliveredDate + ", statusId=" + statusId + "]";
	}
	
	
	
}
