package com.rgt.app;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import com.rgt.app.configuration.CustomUserDetail;
import com.rgt.app.configuration.CustomUserDetailService;
import com.rgt.app.configuration.SecurityConfigure;
import com.rgt.app.configuration.googleOAuth2SuccessHandler;
//@EnableAutoConfiguration(exclude = {SecurityConfigure.class, googleOAuth2SuccessHandler.class,CustomUserDetailService.class,CustomUserDetail.class })

@SpringBootTest
class ECommerceApplication01ApplicationTests {
 
	@Test  
	void contextLoads() { 
	}

}
