package com.rgt.app.controllerTest;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.rgt.app.models.Receipt;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.AddressService;
import com.rgt.app.service.ProductService;
@SpringBootTest
public class CartControllerTest {
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

	
	private void addToCartTest() {
		User user=new User();
		user.setEmail("asdf@gmail.com");
		Receipt re=new Receipt();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
