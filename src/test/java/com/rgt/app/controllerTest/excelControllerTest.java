package com.rgt.app.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import com.rgt.app.controller.AdminController;
import com.rgt.app.models.Product;
import com.rgt.app.repository.ProductReposiory;
//@RunWith(MockitoJUnitRunner.class)
@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest
public class excelControllerTest {
	
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	ProductReposiory productReposiory;
	@Autowired
	AdminController adminController;
	/*
	 * @Autowired private Category category;
	 * 
	 * @Autowired private User user;
	 */
	
	@SuppressWarnings("deprecation")   
	@Test   
//	@WithMockUser(roles = {"USER","ADMIN"})
	public void testDownloadFiles() throws Exception {         
	List <Product> ps=new ArrayList<>();         
	 Product pr=new Product();         
	 pr.setId(1);  
	 pr.setName("name");
	// pr.setCategory(category);
	 pr.setPrice(150);
	 pr.setWeight(200);
	 pr.setDescription("ssxdfcgvhb");
	 pr.setImageName("image");
	// pr.setUser(user);
	       
	 ps.add(pr);         
	 Mockito.when(productReposiory.findAll()).thenReturn(ps);       
	  MvcResult result = mockMvc.perform(multipart("/downloadExcelFile/product.xlsx")
	 
	  .contentType(MediaType.MULTIPART_FORM_DATA))                             
	// .andExpect(MockMvcResultMatchers.status().is(200))                              
	.andReturn();      
	 byte[] bytes = result.getResponse().getContentAsByteArray();      
	 Path path = Paths.get("Product.xlsx");      
	 Files.write(path, bytes);       
	//Assert.assertEquals(200, result.getResponse().getStatus());
} 

	       
	
}
