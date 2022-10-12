package com.rgt.app.controllerTest;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
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
import org.springframework.ui.Model;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.email.EmailSenderService;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@EnableWebMvc
@SpringBootTest
@Import({ SecurityConfigure.class })
public class HomeControllerTest {
	@MockBean
	private Model model;

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

	@Mock
	EmailSenderService emailSenderService;

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })

	public void HomeTest() throws Exception {

		when(model.addAttribute("asd", GlobalData.cart.size())).thenReturn(model);

		List<Receipt> receipt = new ArrayList<>();
		Receipt receipt2 = new Receipt();

		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);
		Mockito.when(receiptRepositoy.save(receipt2)).thenReturn(receipt2);
	//	Mockito.when(emailSenderService.sendEmail(receipt2.getEmail(),receipt2.getEmail(),receipt2.getEmail())).thenReturn();

		this.mockMvc.perform(get("/").contentType(MediaType.ALL));
  
	} 

	@Test
	public void shopTest() throws Exception {
		List<Product> pp = new ArrayList<>();
		List<Category> cc = new ArrayList<>();
		given(productService.getallProducts()).willReturn(pp);
		given(categoryService.getallCategory()).willReturn(cc);
		this.mockMvc.perform(get("/shop").contentType(MediaType.MULTIPART_FORM_DATA));

	}

	@Test
	public void ShopByCategoryTest() throws Exception {
	//	List<Category> categories = new ArrayList<>();
		List<Product> product = new ArrayList<>();
		Product product2 = new Product();
		product2.setId(1);
		System.out.println(productService.getAllProductsByCategoryById(1));
		System.out.println(product2.getId());
		Mockito.when(productService.getAllProductsByCategoryById(1)).thenReturn(product);
		mockMvc.perform(get("/shop/category/{id}", product2.getId()));

	}

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void viewProductTest() throws Exception {
		Category category=new Category();
		category.setName("as");
		Optional<Product> products = Optional.of(new Product());
		Product product = new Product();
		product.setId(1);
		product.getCategory();
 
		Mockito.when(productService.getProductById(1)).thenReturn(products);
		 mockMvc.perform(get("/shop/viewproduct/{id}",1).contentType(MediaType.ALL));
	}  
 
}
  







