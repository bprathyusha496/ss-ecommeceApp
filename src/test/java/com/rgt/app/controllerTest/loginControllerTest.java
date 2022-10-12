package com.rgt.app.controllerTest;


import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureWebMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.ui.Model;

import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.controller.loginController;
import com.rgt.app.email.EmailSenderService;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Role;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.RoleRepository;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.ProductService;


@AutoConfigureMockMvc
@AutoConfigureWebMvc
@SpringBootTest 
@Import({ SecurityConfigure.class })
public class loginControllerTest {
	@InjectMocks
	private loginController loginController;
	@MockBean
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@MockBean
	private UserRepository userRepository;
	@MockBean
	private RoleRepository roleRepository;
	@MockBean
	private EmailSenderService emailSenderService;
	@MockBean
	private ProductReposiory productReposiory;
	@MockBean
	private ReceiptRepositoy receiptRepositoy;
	@MockBean
	private ProductService productService;
	@MockBean
	private GlobalData globalData;
	private Model model;
	
	@Autowired
	MockMvc mockMvc;
	
	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void loginTest() throws Exception {
		
		globalData.cart.clear();
		this.mockMvc.perform(get("/login"));
		
	}  
	@Test
	@WithMockUser(username = "user", authorities = { "ROLE_USER" })
	public void registerGetTest() throws Exception{
		mockMvc.perform(get("/register"));
	}

	
	@Test
	public void registerPostTest() throws Exception  {
		User user=new User(1);
		user.setEmail("ssddf"); 
		user.setId(1);
		
		Optional<Role> roles=Optional.of(new Role());
		Role role=new Role();
		role.setId(2);
		role.setName("vhbjn");
		when(userRepository.findByemail("asdf")).thenReturn(user);
	
	when(roleRepository.findById(2)).thenReturn(roles);
	when(userRepository.save(user)).thenReturn(user);
		this.mockMvc.perform(post("/register")
				.param("id","1")
				.contentType(MediaType.ALL));
		 
	}

}
