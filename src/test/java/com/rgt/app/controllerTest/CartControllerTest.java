package com.rgt.app.controllerTest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.security.Principal;
import java.time.LocalDateTime;
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
import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.CartController;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.AddressService;
import com.rgt.app.service.ProductService;

@AutoConfigureWebMvc
@AutoConfigureMockMvc
@SpringBootTest
@Import({ SecurityConfigure.class })
public class CartControllerTest {
	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private ProductService productService;

	@MockBean
	private AddressService addressService;

	@MockBean
	private UserRepository userRepository;

	@MockBean
	ProductReposiory productReposiory;

	@MockBean
	ReceiptRepositoy receiptRepositoy;

	@Autowired
    private CartController cartController;

	@MockBean
	private Principal principal;
	
    @Mock
    private Model model;
	@Mock
	private GlobalData globalData;
	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void addToCartTest() throws Exception {
		List<Product>products=new ArrayList<>();
		Product product=new Product();
		product.setId(1);
		Optional<User> user=Optional.empty();
		User user2=new User();
		user2.setId(1);
		user2.setEmail("dxfc");
		user2.setFirstName("cfvg");
	
		//user.add(user2);
		
	    Mockito.when(principal.getName()).thenReturn("xfcgh");	
	    Mockito.when(userRepository.findUserByEmail("dxfc")).thenReturn(user);
		Receipt receipt = new Receipt(); 
		receipt.setReceiptid(1);
		Mockito.when(userRepository.findById(1)).thenReturn(user);
		receipt.setUser(1);
		
		Mockito.when(receiptRepositoy.save(receipt)).thenReturn(receipt);
	//	Mockito.when(productService.getProductById(1));
	//	mockMvc.perform(get("/addToCart/{id}",product.get()).param("id", "1").param("name", "asdf").contentType(MediaType.ALL));
		mockMvc.perform(get("/addToCart/{id}",product.getId()).contentType(MediaType.ALL));
	}  

	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void cartGetTest() throws Exception {
		List<Product> products=new ArrayList<>();
		Optional<Product> product=Optional.of(new Product());
		User user=new User();
		List<Receipt> receipt=new ArrayList<>();
		Mockito.when(productReposiory.findAll()).thenReturn(products);
		Mockito.when(userRepository.findByemail(principal.getName())).thenReturn(user);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);
		/*
		 * Mockito.when(productService.getProductById(1)).thenReturn(product);
		 * model.addAttribute("asd",GlobalData.cart);
		 * model.addAttribute("asdf",GlobalData.cart.stream().mapToDouble(Product::
		 * getPrice).sum()); model.addAttribute("asdfg", GlobalData.cart.size());
		 */
		mockMvc.perform(get("/cart").contentType(MediaType.ALL));
	} 

	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void cartGet1Test() throws Exception { 
		Optional<Product> product=Optional.of(new Product());
		List<Product> product1=new ArrayList<>();
		User user=new User();
		List<Receipt> receipt=new ArrayList<>();

	//	Mockito.when(globalData.cart).thenReturn(product1);
		Mockito.when(userRepository.findByemail(principal.getName())).thenReturn(user);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);
		Mockito.when(productService.getProductById(1)).thenReturn(product);
		mockMvc.perform(get("/yourorders").contentType(MediaType.ALL));
	}
 
	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void cartItemRemove() throws Exception {
		Product product=new Product();
//	Mockito.when(globalData.cart.remove(1)).thenReturn(product);
	mockMvc.perform(get("/cart/removeItem/{index}",product.getId()).contentType(MediaType.ALL));
		  
		}

	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void cartItemaddTest() { 
		// @GetMapping("/cart/addItem/{id}") 
		}
	
	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void checkoutTest() {
		// @GetMapping("/checkout") 
		}
	

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void checkout1Test() throws Exception { 
		
		// @postMapping("/checkout") 
		Receipt receipt=new Receipt();
		receipt.setOrderDate(LocalDateTime.now());
		receipt.setDeliveredDate(receipt.getOrderDate());
		model.addAttribute(receipt);
	 receipt.setDeliveredDate(receipt.getOrderDate().plusDays(1));
		cartController.checkout1(model, principal);
		
		mockMvc.perform(post("/checkout").contentType(MediaType.ALL));
		}
	

	@Test 
	@WithMockUser(username = "user", authorities = { "ROLE_USER"})
	public void sucessmethodTest() {
		// @PostMapping("/success")
		}
	
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  }
