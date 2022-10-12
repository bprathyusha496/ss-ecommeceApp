package com.rgt.app.repoTest;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.rgt.app.models.Receipt;
import com.rgt.app.repository.ReceiptRepositoy;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class receiptRepoTest {
	@Autowired 
	ReceiptRepositoy receiptRepositoy;
	
	
	@BeforeEach
	void setup() {
		Receipt re=new Receipt();
		re.setReceiptid(1);
		re.setEmail("asdf@gmail.com");
		re.setName("fgvhb");
		receiptRepositoy.save(re);

	}
	
	@SuppressWarnings("deprecation")
	@Test
	void savemethodTest() {
		
		Receipt receipt=receiptRepositoy.getById(1);
		assertEquals("asdf@gmail.com",receipt.getEmail());
		
	}

}
