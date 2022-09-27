package com.rgt.app.configureTest;

import org.junit.jupiter.api.Order;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@SuppressWarnings("deprecation")
@TestConfiguration
@Order(1)
public class ConfigureTest extends WebSecurityConfigurerAdapter{
	@Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // Disable CSRF 
        httpSecurity.csrf().disable()
                // Permit all requests without authentication
                .authorizeRequests().anyRequest().permitAll();
    }

	

}









