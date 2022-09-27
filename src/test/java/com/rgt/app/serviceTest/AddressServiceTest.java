package com.rgt.app.serviceTest;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.rgt.app.email.EmailSenderService;
import com.rgt.app.models.Address;
import com.rgt.app.models.Category;
import com.rgt.app.repository.AddressRepository;
import com.rgt.app.service.AddressService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class AddressServiceTest {  
	@Mock
	private AddressRepository addressRepository;
	@Mock
	private EmailSenderService emailSenderService;
	@InjectMocks
	private AddressService addressService;

	 
	@Test
	public void saveAddressTest() {  
		Address address=new Address();
		address.setFirstName("sdds");
		address.setEmail("bprathyu@gmail.com");
		Mockito.when(addressRepository.save(address)).thenReturn(address);
		addressService.saveaddress(address); 
	}
	
	@Test
	public void CustomUserDetailServiceTest() {
		
	}
}
