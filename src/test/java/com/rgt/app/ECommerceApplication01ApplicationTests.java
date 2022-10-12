package com.rgt.app;

import java.io.IOException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
class ECommerceApplication01ApplicationTests {
 
	@Test  
	void contextLoads() {  
	}
	
	@Test
	public void testMain() throws IOException { 
	    System.out.println("main");
	    String[] args = null;
	}

	@Test
	public void ECommerceApplication01ApplicationTest() {
		ECommerceApplication01Application.main(new String[] {});
	}
	
}
