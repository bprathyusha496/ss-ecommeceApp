package com.rgt.app.controllerTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.security.Principal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

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
import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.CartController;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Address;
import com.rgt.app.models.Category;
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

	@Mock
	private ProductService productService;

	@Mock
	private AddressService addressService;

	@Mock
	private UserRepository userRepository;

	@Mock
	ProductReposiory productReposiory;

	@Mock
	ReceiptRepositoy receiptRepositoy;

	@InjectMocks
	private CartController cartController;

	@MockBean
	private Principal principal;

//	@MockBean
//	private LocalDateTime order;

	@Mock
	private Model model;

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void addToCartTest() throws Exception {

		User user = new User();
		user.setId(1);
		user.setEmail("asdf");
		when(principal.getName()).thenReturn("fgh");
		when(userRepository.findUserByEmail("asdf")).thenReturn(Optional.of(user));
		Receipt receipt = new Receipt();
		receipt.setConfirm("tgyh");
		receipt.setProductId(1);
		// receipt.setUser(user.getId());
		Product product = new Product();
		when(productService.getProductById(1)).thenReturn(Optional.of(product));
		when(receiptRepositoy.save(receipt)).thenReturn(receipt);
		cartController.addToCart(1, model, principal);

	}

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void cartGetTest() throws Exception {
		List<Product> products = new ArrayList<>();
		Product product = new Product();
		product.setId(1);
		User user = new User();
		user.setId(1);
		user.setEmail("fcvghb");

		products.add(product);
		List<Receipt> receipt = new ArrayList<>();
		Receipt receipt2 = new Receipt();
		receipt2.setConfirm("vgbh");
		receipt2.setUser(1);
		receipt2.setProductId(1);
		receipt.add(receipt2);
		Mockito.when(productReposiory.findAll()).thenReturn(products);
		Mockito.when(userRepository.findByemail(Mockito.anyString())).thenReturn(user);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);

		cartController.cartGet(model, principal);
		// mockMvc.perform(get("/cart").contentType(MediaType.ALL));
	}

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void cartGet1Test() throws Exception {
        Category category=new Category();
        User user = new User();
        user.setId(1);
        
		List<Product> product1 = new ArrayList<>();
		Product product = new Product();
		
		product1.add(product);
		product.setId(1);
		product.setUser(user);
		List<Receipt> receipt = new ArrayList<>();
		Receipt receipt2=new Receipt();
		receipt.add(receipt2);
		 
		receipt2.setReceiptid(1);
		receipt2.setCategory("cfvg");
		receipt2.setProductId(1);
		receipt2.setUser(1);
		
		
		Mockito.when(userRepository.findByemail(principal.getName())).thenReturn(user);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);
		Mockito.when(productService.getProductById(1)).thenReturn(Optional.of(product));
		cartController.cartGet1(model, principal);
	
	}

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void cartItemRemoveTest() throws Exception {
		Product product = new Product();
		product.setId(1);

		GlobalData.cart.add(product);

//		List<Product> carts = new ArrayList<>();
//		carts.add(product);
//	    Mockito.when(GlobalData.cart.remove(Mockito.anyInt()))).thenReturn(1);
//		doNothing().when(GlobalData.cart).remove(Mockito.anyInt());
//		Whitebox.setInternalState(MyTestClass.class, "myCar", carMock);

		mockMvc.perform(get("/cart/removeItem/{index}", 0));
		// cartController.cartItemRemove(1);
	}


	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void cartItemaddTest() throws Exception {
		// @GetMapping("/cart/addItem/{id}")
		List<Receipt> receipt = new ArrayList<>();
		Receipt rc=new Receipt();
		rc.setProductId(1);
		rc.setConfirm("pending");
		rc.setUser(1);
		receipt.add(rc);

		User user = new User();
		user.setId(1);

		Category cat=new Category();
		cat.setId(1);
		
		Product product2 = new Product();
		product2.setUser(user);
		product2.setCategory(cat);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);

		Mockito.when(productReposiory.findById(1)).thenReturn(Optional.of(product2));
		Mockito.when(userRepository.findByemail(principal.getName())).thenReturn(user);
		Mockito.when(receiptRepositoy.save(rc)).thenReturn(rc);
		// mockMvc.perform(get("/cart/addItem/{id}",1).contentType(MediaType.ALL));
		cartController.cartItemadd(1, principal);
	
	}
	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void checkoutTest() throws Exception {
		// @GetMapping("/checkout")
		// @GetMapping("/cart/addItem/{id}")
				List<Receipt> receipt = new ArrayList<>();
				Receipt rc=new Receipt();
				rc.setProductId(1);
				rc.setConfirm("pending");
				rc.setUser(1);
				receipt.add(rc);

				User user = new User();
				user.setId(1);

				Category cat=new Category();
				cat.setId(1);
				
				Product product2 = new Product();
				product2.setUser(user);
				product2.setCategory(cat);
				Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);

		Mockito.when(userRepository.findByemail(user.getEmail())).thenReturn(user);
		cartController.checkout(model, principal);
		
		rc.setConfirm("yghu");
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipt);

		Mockito.when(userRepository.findByemail(user.getEmail())).thenReturn(user);

		
		cartController.checkout(model, principal);

		
	//	cartController.checkout(model, principal);
	}

	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void checkout1Test() throws Exception {
		LocalDateTime time=LocalDateTime.now();
		Receipt receipt=new Receipt();
		receipt.setOrderDate(time.minusDays(1));
		receipt.setDeliveredDate(time.plusDays(1));

	//	Assert.assertTrue(receipt.getOrderDate().isBefore(receipt.getDeliveredDate()));

		cartController.checkout1(model, principal);
	}

 
	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void sucessmethodTest() {
		// @PostMapping("/success")
		Address address = new Address();
		Product p = new Product();
		List<Receipt> receipts = new ArrayList<>();
		Receipt receipt = new Receipt();
		receipts.add(receipt);
		Mockito.when(receiptRepositoy.findAll()).thenReturn(receipts);
		Mockito.when(addressService.saveaddress(address)).thenReturn(address);

		cartController.sucessmethod(model, address, principal, p);
	}

}
