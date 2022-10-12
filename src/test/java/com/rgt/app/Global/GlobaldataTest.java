package com.rgt.app.Global;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Product;

@SpringBootTest(classes = GlobalData.class)
public class GlobaldataTest {
	
	
	  public static List<Product> cart;
	  
	  @Test 
	  public void GlobalDataTest() { 
	    List<Product> products=new ArrayList();
	    GlobalData.cart=products;
	  
	  }
	 
}
