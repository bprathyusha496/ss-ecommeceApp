package com.rgt.app.controller;

import java.security.Principal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.rgt.app.email.EmailSenderService;
import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Address;
import com.rgt.app.models.Receipt;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;

@Controller
public class HomeController {
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	@Autowired
	UserRepository userRepository;
	@Autowired
	ReceiptRepositoy receiptRepositoy;
	
	@Autowired
	private EmailSenderService emailSenderService;
	
	@GetMapping("/") 
	public String home(Model model) {  
		model.addAttribute("cartCount",GlobalData.cart.size());
		
		LocalDate currentdate = LocalDate.now();
		List<Receipt> rec=receiptRepositoy.findAll();
		
	   for(Receipt re:rec) {
	   if(re.getStatusId()==0) {
		   
	   if(re.getConfirm().equals("confirm") && (currentdate.isEqual(LocalDate.from(re.getDeliveredDate().minusDays(2))))){
		   
	        re.setStatusId(1);
	        receiptRepositoy.save(re);
	    emailSenderService.sendEmail(re.getEmail(),"SS-ecommerce",("Hi..\n"+"Dear customer "+"\n"+"Your order is in our hyderabad store, Delivered at "+re.getDeliveredDate()+"\n"+"Please be available.."));
        System.out.println("email is working.. ");
        
		} 
	   
	   }
	   }
		return "index";
	}
	@GetMapping("/shop")  
	public String Shop(Model model) {
		
		  model.addAttribute("categories", categoryService.getallCategory());
		  model.addAttribute("products",productService.getallProducts());
		  model.addAttribute("cartCount",GlobalData.cart.size());

		 return "shop";
	}

	@GetMapping("/shop/category/{id}")
	public String ShopByCategory(Model model , @PathVariable int id) {
		  model.addAttribute("categories", categoryService.getallCategory());
		  model.addAttribute("products",productService.getAllProductsByCategoryById(id));
		  model.addAttribute("cartCount",GlobalData.cart.size());
		
		return "shop";
	}
	@GetMapping("/shop/viewproduct/{id}")
	public String viewProduct(Model model,@PathVariable int id) {
		model.addAttribute("product", productService.getProductById(id).get());
		model.addAttribute("cartCount",GlobalData.cart.size());

		return "viewProduct";
			}
	

	@GetMapping("/getbyemail/{email}")
	public String detailsofuser(@PathVariable String email, Model model,Principal principal) {
		//User u=(userRepository.findByemail(principal.getName()));
		
		model.addAttribute("useremail",receiptRepositoy.getByEmail(email));
		System.out.println(email);
		
		return "cart";
		
	}
	}
