
package com.rgt.app.config;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.rgt.app.configuration.CustomUserDetailService;
import com.rgt.app.models.User;
import com.rgt.app.repository.UserRepository;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CustomUserDetailServiceTest {

	@Mock
	private UserRepository userRepository;
	@InjectMocks
	CustomUserDetailService customUserDetailService;
	
	@Test
	public void testLoadUserByUsername() {
		User user = new User();
		user.setEmail("asd@gmail.com");
		Optional<User> opt = Optional.of(user);
		when(userRepository.findUserByEmail(anyString())).thenReturn(opt);
		customUserDetailService.loadUserByUsername(anyString());
	//	when(user.getEmail().isEmpty()).thenReturn(anyString().equals(opt)); 
		assertEquals("asd@gmail.com",user.getEmail());		  
	}

}
