package com.rgt.app.global;

import java.util.ArrayList;
import java.util.List;
import com.rgt.app.models.Product;

import lombok.Builder;


public class GlobalData {
	

	  public static List<Product> cart;
	  
	  
	  static { 
		  cart=new ArrayList<Product>();
		  
		  }
}
