package com.rgt.app.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.rgt.app.email.EmailSenderService;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.models.Role;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.RoleRepository;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.ProductService;

@Controller
public class loginController {
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	@Autowired
	private ProductReposiory productReposiory;
	@Autowired
	private ReceiptRepositoy receiptRepositoy;
	@Autowired
	private ProductService productService;
	
	@GetMapping("/login")
	public String login(Principal principal) {
		GlobalData.cart.clear();
		/*
		 * List<Product> pr=productReposiory.findAll(); User objj =
		 * userRepository.findByemail(principal.getName()); List<Receipt> receipt =
		 * receiptRepositoy.findAll(); for (Receipt re : receipt) { for(Product p:pr) {
		 * if(re.getConfirm().equals("pending") && re.getUser() == (objj.getId())&&
		 * re.getProductId()==p.getId()) {
		 * productService.getProductById(p.getId()).get(); }else {
		 * GlobalData.cart.clear(); } }
		 * 
		 * }
		 */
		return "login";
		
	}	
	/*
	 * @GetMapping("/logout") 
	 * public String logout(){ 
	 * return "index"; 
	 * }
	 */
	
	  @GetMapping("/register") 
	  public String registerGet() { 
		  return "register"; 
		  }
	@PostMapping("/register") 
	public String registerPost(Model model,@ModelAttribute("user") User user,HttpServletRequest request,BindingResult result)throws ServletException {
				
		 User existingUser = userRepository.findByemail(user.getEmail());
		 if(existingUser !=null &&(existingUser.equals(existingUser))) {
			 
			result.rejectValue("email","There is already an account registered with the same");
		  
		if(result.hasErrors()){
            model.addAttribute("user", user);
            return "/register";
        }
		}else {
			
			  if(existingUser != null && existingUser.getEmail() != null &&
			  !existingUser.getEmail().isEmpty()){ result.rejectValue("email", null,
			  "There is already an account registered with the same email"); }
			 
        	String password=user.getPassword();
         	user.setPassword(bCryptPasswordEncoder.encode(password));
    		List<Role>roles=new ArrayList<>();
    		roles.add(roleRepository.findById(2).get());
    		user.setRoles(roles);
		userRepository.save(user);
		//request.login(user.getEmail(),password);
	}
		return "redirect:/login";
	}
	
}

