package com.rgt.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

import com.rgt.app.configuration.CustomUserDetail;
import com.rgt.app.configuration.CustomUserDetailService;
import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.configuration.googleOAuth2SuccessHandler;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.AddressService;
//@EnableAutoConfiguration(exclude = {SecurityConfigure.class, googleOAuth2SuccessHandler.class,CustomUserDetailService.class,CustomUserDetail.class })
@SpringBootApplication
public class ECommerceApplication01Application {


	public static void main(String[] args) {
		
		SpringApplication.run(ECommerceApplication01Application.class, args);
		
		
	}

}
