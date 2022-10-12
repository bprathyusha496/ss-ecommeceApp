package com.rgt.app.controllerTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
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
import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.AdminController;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
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

	@MockBean
	private CategoryService categoryService;

	@MockBean
	private ProductService productService;

	@MockBean
	private ProductReposiory productReposiory;

	@MockBean
	ReceiptRepositoy receiptRepositoy;

	@Autowired
	private AdminController adminController;

	@MockBean
	UserRepository userRepository;
	
	private Model model;

	Category category = new Category();

	Product p1 = new Product(1, "pens", category, 50, 200, "dxcfgvbh", "cello");
	Product p2 = new Product(2, "pets", category, 100, 400, "dxcfgvbh", "dogs");
	Product p3 = new Product(3, "pins", category, 220, 10, "dxcfgvbh", "fancystore");

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
	public void getCategoriesAddTest() throws Exception {
		Category category=new Category();

			 
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
	public void deleteCatTest() throws Exception {
		Optional<Category> category = Optional.of(new Category());
		Category category1 = new Category();
		given(categoryService.getCategoryById(1)).willReturn(category);

		this.mockMvc.perform(get("/admin/categories/delete/{id}", category1.getId()));
	}
 
	/*
	 * @Test
	 * 
	 * @WithMockUser(username = "admin", authorities = {"ROLE_ADMIN"}) public void
	 * updateCatTest() throws Exception {
	 * 
	 * Optional<Category> category =Optional.of(new Category());; Category
	 * category1=new Category();
	 * given(categoryService.getCategoryById(1)).willReturn(category);
	 * 
	 * this.mockMvc.perform(get("/admin/categories/update/{id}",category1.getId()).
	 * contentType(MediaType.ALL)); //// Optional<Category> category20
	 * =Optional.of(new Category());
	 * 
	 * Category ob=new Category();
	 * Mockito.when(categoryService.getCategoryById(1)).thenReturn(category20);
	 * System.out.println(categoryService.getCategoryById(1));
	 * System.out.println(ob.getId());
	 * mockMvc.perform(get("/admin/categories/update/{category20.id}", ob.getId()));
	 * // .andExpect(status().isOk()); }
	 */

	/*
	 * mockMvc.perform(post("/admin/product/update/{id}",category.getId()).
	 * contentType(MediaType.ALL) .param("id", "1") .param("name","dfgh")
	 * .contentType(MediaType.ALL));
	 */

	// Product section

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void productinfoTest() throws Exception {
		// getallproducts

		List<Product> pp = new ArrayList<>();
		given(productService.getallProducts()).willReturn(pp);
		this.mockMvc.perform(get("/admin/products").contentType(MediaType.ALL));
		// .andExpect(status)
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
		Product pp = new Product();

		given(productReposiory.save(pp)).willReturn(pp);

		mockMvc.perform(post("/admin/products/add").param("id", "1").param("name", "ghnj").param("ImageName", "hbgvfc")

				.contentType(MediaType.MULTIPART_FORM_DATA));

	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void deleteProductTest() throws Exception {
		Optional<Product> products = Optional.of(new Product());
		
		Product product = new Product();
		given(productService.getProductById(1)).willReturn(products);

		this.mockMvc.perform(get("/admin/product/delete/{id}", product.getId()));

	}

	@Test
	@WithMockUser(username = "admin", authorities = { "ROLE_ADMIN" })
	public void uploadProductGetTest() throws Exception {
		Optional<Product> product = Optional.of(new Product());
		Product product2 = new Product();
		Optional<Category> cat = Optional.of(new Category());
		Category category = new Category();

		// given(productService.getProductById(1)).willReturn(product);
		// given(categoryService.getCategoryById(1)).willReturn(cat);
		mockMvc.perform(get("/admin/product/update/{id}", product.get()).param("id", "1").param("name", "dfgh")

				.contentType(MediaType.ALL));
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
