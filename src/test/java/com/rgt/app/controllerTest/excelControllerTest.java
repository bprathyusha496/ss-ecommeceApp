package com.rgt.app.controllerTest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.AdminController;
import com.rgt.app.excel.ExcelFileGenerator;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.repository.ProductReposiory;

@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest
@Import({ SecurityConfigure.class })
public class excelControllerTest { 
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	ProductReposiory productReposiory;
	@MockBean
	AdminController adminController;
	@MockBean
	private ExcelFileGenerator excelFileGenerator;
	/*
	 * @Autowired private Category category;
	 * 
	 * @Autowired private User user;
	 */
	
	@Test   
	@WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"})
	public void excelProductReportTest() throws Exception {    
		Category category=new Category();
		List<Product> pp = new ArrayList<>(); 
		Product product=new Product();
		product.setId(1);
		product.setName("assd");
		product.setCategory(category);
		product.setPrice(10);
		product.setWeight(150);
		product.setDescription("add");
		product.setImageName("vghb");
		 
		pp.add(product);
		Mockito.when(productReposiory.findAll()).thenReturn(pp);
		given(productReposiory.findAll()).willReturn(pp);
		this.mockMvc.perform(get("/downloadExcelFile/product.xlsx").contentType(MediaType.ALL));
		
		
	}
	

	       
	
}
