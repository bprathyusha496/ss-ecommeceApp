package com.rgt.app.global;

import java.util.ArrayList;
import java.util.List;

import com.nimbusds.openid.connect.sdk.claims.Address;
import com.rgt.app.models.Product;

public class GlobalData {
	

	  public static List<Product> cart;
	  
	  
	  static { 
		  cart=new ArrayList<Product>();
		  
		  }
	 
	
}
