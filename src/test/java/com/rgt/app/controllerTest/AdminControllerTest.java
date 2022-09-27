
package com.rgt.app.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.security.RolesAllowed;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.AutoConfigureJsonTesters;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.config.web.servlet.oauth2.client.OAuth2ClientSecurityMarker;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.rgt.app.configuration.CustomUserDetail;
import com.rgt.app.controller.AdminController;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;


@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest
//@WebMvcTest(AdminController.class)
public class AdminControllerTest {   

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private CategoryService categoryService;

	@MockBean
	private ProductService productService;

	@MockBean
	private ProductReposiory productReposiory;

	@MockBean
	ReceiptRepositoy receiptRepositoy;

	@InjectMocks
	AdminController adminController;

	@MockBean
	UserRepository userRepository; 
	Category category = new Category();

	Product p1 = new Product(1, "pens", category, 50, 200, "dxcfgvbh", "cello");
	Product p2 = new Product(2, "pets", category, 100, 400, "dxcfgvbh", "dogs");
	Product p3 = new Product(3, "pins", category, 220, 10, "dxcfgvbh", "fancystore");

	
	
	@Test
	public void contextLoads() throws Exception {
		assertThat(adminController).isNotNull();
	}

	@Test
//	@OAuth2ClientSecurityMarker
	public void AdminTest() throws Exception {
		this.mockMvc.perform(get("/admin"));
	}

	/*
	 * @SuppressWarnings("deprecation")
	 * 
	 * @Test public void gettingAllProductsTest() throws Exception { List<Product>
	 * records = new ArrayList<>(Arrays.asList(p1, p2, p3));
	 * 
	 * when(productService.getallProducts()).thenReturn(records);
	 * mockMvc.perform(get("/admin/products")).andExpect(status().isOk()) //
	 * .andExpect() .andExpect(jsonPath("$",
	 * hasItems(1))).andExpect(jsonPath("$[0].id", is(1)))
	 * .andExpect(jsonPath("$[0].name",
	 * is("pens"))).andExpect(jsonPath("$[0].category", is("category")))
	 * .andExpect(jsonPath("$[0].price", is(50))).andExpect(jsonPath("$[0].weight",
	 * is(200))) .andExpect(jsonPath("$[0].description", is("dxcfgvbh")))
	 * .andExpect(jsonPath("$[1].imageName", is("cello"))); verify(productService,
	 * times(1)).getallProducts(); verifyNoMoreInteractions(productService);
	 * 
	 * List<Product> p = new ArrayList<>();
	 * given(productReposiory.findAll()).willReturn(p);
	 * ((MockHttpServletRequestBuilder)
	 * mockMvc.perform(get("/admin/products")).andExpect(status().isOk()))
	 * .contentType(MediaType.APPLICATION_JSON_UTF8); }
	 */ 
private List<Category> cc = new ArrayList<>();
	@Test
	@OAuth2ClientSecurityMarker
	public void getCategoriesTest() throws Exception {  
		List<Category> cc = new ArrayList<>();
		given(categoryService.getallCategory()).willReturn(cc);
		this.mockMvc.perform(get("/admin/categories"));
		//.andExpect(status)
	}

	@Test
	public void gettingAllProductswithCategoryTest() throws Exception {
		List<Category> cc = new ArrayList<>();
		given(categoryService.getallCategory()).willReturn(cc);
		mockMvc.perform(get("/admin/products/add").contentType(MediaType.ALL));
	}

	@Test
	public void saveproductsTest() throws Exception {
		Product pp = new Product();
		Category ca = new Category();
		given(productReposiory.save(pp)).willReturn(pp);
		given(categoryService.addCategory(ca)).willReturn(ca);
		mockMvc.perform(get("/admin/products/add").param("id", "1").param("name", "ghnj").param("category", "books")
				.contentType(MediaType.ALL));

	}

	

	@SuppressWarnings("deprecation")
	public void savecategoryTest() throws Exception {
		Category category=new Category();
		given(categoryService.addCategory(category)).willReturn(category);
		this.mockMvc.perform((RequestBuilder) ((ResultActions) post("/admin/add")
			.param("id", "1").param("name", "sdfg")
		.contentType(MediaType.ALL))  
	    .andExpect(status().isOk()));

	}  

	/*
	 * @Test public void getCategoriesAddTest() throws Exception { Category ca = new
	 * Category();
	 * 
	 * given(ca).willReturn(ca);
	 * mockMvc.perform(get("/admin/categories").param("id",
	 * "1").contentType(MediaType.ALL)); }
	 */
}
