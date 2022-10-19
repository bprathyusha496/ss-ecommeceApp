package com.rgt.app.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.mail.Multipart;

import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
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
import org.springframework.web.multipart.MultipartFile;

import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.AdminController;
import com.rgt.app.dto.ProductDTO;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest
@Import({ SecurityConfigure.class })
public class AdminControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Mock
	private CategoryService categoryService;

	@Mock
	private ProductService productService;

	@Mock
	private ProductReposiory productReposiory;

	@Mock
	ReceiptRepositoy receiptRepositoy;

	@InjectMocks
	private AdminController adminController;

	@Mock
	private UserRepository userRepository;
	@Mock
	private MultipartFile multipart;
	@Mock
	private Model model;
	
	/*
	 * Category category = new Category();
	 * 
	 * Product p1 = new Product(1, "pens", category, 50, 200, "dxcfgvbh", "cello");
	 * Product p2 = new Product(2, "pets", category, 100, 400, "dxcfgvbh", "dogs");
	 * Product p3 = new Product(3, "pins", category, 220, 10, "dxcfgvbh",
	 * "fancystore");
	 */

	@Test
	public void contextLoads() throws Exception {
		assertThat(adminController).isNotNull();
	} 

	
	  @Test 
	  public void AdminHomeTest() throws Exception {
	  this.mockMvc.perform(get("/admin")); }
	 

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void getCategoriesTest() throws Exception {
		List<Category> cc = new ArrayList<>();
		given(categoryService.getallCategory()).willReturn(cc);
		this.mockMvc.perform(get("/admin/categories").contentType(MediaType.ALL));
	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void getCategoriesAddTest() throws Exception{
	//	adminController.getCategoriesAdd(model);
		mockMvc.perform(get("/admin/categories/add").contentType(MediaType.ALL));

			 
		}
		
	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void postcatAddTest() throws Exception {
		// post the cateogories
		Category category = new Category();
		given(categoryService.addCategory(category)).willReturn(category);
		mockMvc.perform(
		post("/admin/categories/add").param("id", "1").param("name", "dfgh").contentType(MediaType.ALL));

	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void deleteCatTest() {
		
		Category category = new Category();
		given(categoryService.getCategoryById(1)).willReturn(Optional.of(category));
		adminController.deleteCat(1);
	}
 
	@SuppressWarnings("static-access")
	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void updateCatTest() throws Exception {//if success case
		Category category =new Category();
		category.setId(1);
		Optional<Category> category2=Optional.of(category);
		category2.equals(category.getId());
		Mockito.when(categoryService.getCategoryById(1)).thenReturn(Optional.of(category));
	   Assert.assertEquals(true,category2.isPresent());
	
	   given(categoryService.getCategoryById(1)).willReturn(category2);
	
	    adminController.updateCat(1, model);
	}
	
	@SuppressWarnings("static-access")
	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void updateCatTest1() throws Exception {
		//else part
	adminController.updateCat(1, model); 
	}
	// Product section

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void productinfoTest() throws Exception {
		// getallproducts
		Product product=new Product(); 
		product.setId(1);
		Category category=new Category();
		category.setName("dfgh");		
		product.setCategory(category); 
		User user=new User();
		user.setId(1);
		List<Product> pp = new ArrayList<>();
		product.setCategory(category);
		product.setId(1);
	
		Mockito.when(productService.getallProducts()).thenReturn(pp);
		//mockMvc.perform(get("/admin/products").contentType(MediaType.ALL));
		adminController.productsinfo(model);
	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void ProductAddGetTest() throws Exception {
		Product product = new Product();
		product.setId(1);
		product.setName("gfds");
		product.setPrice(125);
		product.setWeight(1452);

		List<Category> cc = new ArrayList<>();
		given(categoryService.getallCategory()).willReturn(cc);
		mockMvc.perform(get("/admin/products/add").contentType(MediaType.ALL));
	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void ProductAddPostTest() throws Exception {
		ProductDTO dto=new ProductDTO();
		dto.setId(1);
		dto.setCategoryId(1);
		dto.setImageName("dfg");
		dto.setName("sdf");
		Category category=new Category();
		category.setId(1);
		List<Product>products=new ArrayList<>();
		Product pp = new Product();
		pp.setId(dto.getId());
		pp.setName(dto.getName());
		pp.setImageName(dto.getImageName());
		pp.setCategory(category);
	    products.add(pp);
		Mockito.when(categoryService.getCategoryById(1)).thenReturn(Optional.of(category));
		 doNothing().when(productService).addProduct(pp);
		adminController.productAddPost(dto, multipart, "mmm");
      

	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void deleteProductTest() throws Exception {

	doNothing().when(productService).removeProductById(Mockito.anyInt());
	adminController.deleteProduct(1);
	} 

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void uploadProductGetTest() throws Exception {
		User user =new User();
		Product product = new Product();
		Optional<Category> cat = Optional.of(new Category());
		Category category = new Category();
		product.setId(1);
		product.setCategory(category);
		product.setName("fcgvb");
		product.setPrice(10);
		product.setUser(user);
        Mockito.when(productService.getProductById(1)).thenReturn(Optional.of(product));

	 	adminController.uploadProductGet(1, model);
	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void getallOrdersTest() throws Exception {
		// getalluserOrders
		List<Receipt> receipts = new ArrayList<>();
		given(receiptRepositoy.findAll()).willReturn(receipts);
		this.mockMvc.perform(get("/getalluserOrders").contentType(MediaType.ALL));
	}

	/*
	 * @SuppressWarnings("deprecation") public void savecategoryTest() throws
	 * Exception { Category category=new Category();
	 * given(categoryService.addCategory(category)).willReturn(category);
	 * this.mockMvc.perform((RequestBuilder) ((ResultActions) post("/admin/add")
	 * .param("id", "1").param("name", "sdfg") .contentType(MediaType.ALL))
	 * .andExpect(status().isOk()));
	 * 
	 * }
	 */
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

}
