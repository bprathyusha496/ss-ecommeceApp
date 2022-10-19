package com.rgt.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.rgt.app.email.EmailSenderService;
import com.rgt.app.models.Address;
import com.rgt.app.repository.AddressRepository;

@Service 
public class AddressService {
	@Autowired
	private AddressRepository addressRepository;
	
	
	//@Autowired 
//	private UserRepository userRepository;
	@Autowired
	private EmailSenderService emailSenderService;
	
	
    @RequestMapping("/address")
	public Address saveaddress(Address address) {
		
		   emailSenderService.sendEmail(address.getEmail(),"SS-ecommerce",("Hi..\n"+ address.getFirstName()+"\n"+"Total amount of this order "+"\n"+address.getTotal()+"\n"+"Your order is placed and delivered in 2 days"));
		  
		   return	addressRepository.save(address);
		}
    
	
}
