package com.rgt.app.models;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	//@Size(min = 8,max = 8)
	private int billNumber;
	private String firstName;
	private String lastName;
	private String Address;
	private long phoneNumber;
	private String email;
	//@Size(min = 12,max = 16)
	private long cardNumber;
	@DateTimeFormat(pattern = "MM/yy")
	private Date monthAndYear;
	//@Size(min = 3,max = 4)
	private int cvvCode;
	private String cardName;
	private double total;
	/*
	 * @OneToOne(cascade = CascadeType.ALL)
	 * 
	 * @JoinColumn(name = "id") private User user;
	 */
	
	public int getBillNumber() {
		return billNumber;
	}
	public void setBillNumber(int billNumber) {
		this.billNumber = billNumber;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public Date getMonthAndYear() {
		return monthAndYear;
	}
	public void setMonthAndYear(Date monthAndYear) {
		this.monthAndYear = monthAndYear;
	}
	public int getCvvCode() {
		return cvvCode;
	}
	public void setCvvCode(int cvvCode) {
		this.cvvCode = cvvCode;
	}
	public String getCardName() {
		return cardName;
	}
	public void setCardName(String cardName) {
		this.cardName = cardName;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	@Override
	public String toString() {
		return "Address [billNumber=" + billNumber + ", firstName=" + firstName + ", lastName=" + lastName
				+ ", Address=" + Address + ", phoneNumber=" + phoneNumber + ", email=" + email + ", cardNumber="
				+ cardNumber + ", monthAndYear=" + monthAndYear + ", cvvCode=" + cvvCode + ", cardName=" + cardName
				+ ", total=" + total + "]";
	}
	
	
	
	

}
