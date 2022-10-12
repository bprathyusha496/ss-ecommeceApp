package com.rgt.app.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "User")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String firstName;
	private String lastName;
	private String email;

	private String password;
	
	@ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
	@JoinTable(name = "user_role",
	           joinColumns = { @JoinColumn(name="USER_ID",referencedColumnName = "ID")},
	           inverseJoinColumns = {@JoinColumn(name="ROLE_ID",referencedColumnName = "ID")})
	private List<Role>roles;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Product> product;
	
      public User(User user) {
		
		this.firstName = user.getFirstName();
		this.lastName = user.getLastName();
		this.email = user.getEmail();
		this.password =user.getPassword();
		this.roles = user.getRoles();
		
	}
public User() {
	
}
	
	  public User(int i) {
	// TODO Auto-generated constructor stub
}
	public int getId() { 
		  return id;
	  }
	  
	  
	  public void setId(int id) { this.id = id; }
	  
	  
	  public String getFirstName() { return firstName; }
	  
	  
	  public void setFirstName(String firstName) { this.firstName = firstName; }
	  
	  
	  public String getLastName() { return lastName; }
	  
	  
	  public void setLastName(String lastName) { this.lastName = lastName; }
	  
	  
	  public String getEmail() { return email; }
	  
	  
	  public void setEmail(String email) { this.email = email; }
	  
	  
	  public String getPassword() { return password; }
	  
	  
	  public void setPassword(String password) { this.password = password; }
	 
	  public List<Role> getRoles() { return roles; }
	
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}
	
	
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
	
	  
	  
	  
	 

	
	
	
	

}
