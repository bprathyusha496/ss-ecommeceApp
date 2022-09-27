package com.rgt.app.controllerTest;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import com.rgt.app.email.EmailSenderService;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest(classes = com.rgt.app.controller.HomeController.class)
@ActiveProfiles(value = "test")
public class HomeControllerTest {
	@Autowired
	private MockMvc mockMvc;
	@MockBean
	CategoryService categoryService;
	@MockBean
	ProductService productService;
	@MockBean
	UserRepository userRepository;
	@MockBean
	ReceiptRepositoy receiptRepositoy;
	
	@MockBean
	private EmailSenderService emailSenderService;
	@Test 
	public void shopTest() throws Exception {
		List<Product> pp = new ArrayList<>();
		List<Category> cc=new ArrayList<>();
		given(productService.getallProducts()).willReturn(pp);
		given(categoryService.getallCategory()).willReturn(cc);
		
			this.mockMvc.perform(get("/shop").contentType(MediaType.ALL));
			this.mockMvc.perform(get("/shop").contentType(MediaType.ALL));
			
		
		//.andExpect(status) 
	}

}
