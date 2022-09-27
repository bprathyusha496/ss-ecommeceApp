package com.rgt.app.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.service.ProductService;
import static org.mockito.BDDMockito.given;

//@RunWith(SpringRunner.class)
@SpringBootTest 
public class ProductServiceTest {      

	@InjectMocks
	private ProductService productService;
	@Mock
	private ProductReposiory productReposiory;
	@Mock
	private Category category;
   
	@Test
	public void addproducttest() {
		Product product = new Product();
		product.setName("asdf");
		Mockito.when(productReposiory.save(product)).thenReturn(product);
		productService.addProduct(product);
	}

	

	@Test
	public void whenFindAllProductListtest() {
		Product p = new Product();
		List<Product> expectedDisplay = Arrays.asList(p);
		doReturn(expectedDisplay).when(productReposiory).findAll();
		List<Product> actualDisplay = productService.getallProducts();
		assertThat(actualDisplay).isEqualTo(expectedDisplay);

	}
	@Test
	public void getByProductid() {
		
		productService.getProductById(1);
		verify(productReposiory,times(1)).findById(1);
		//assertThat(productReposiory.findById(1)).isEqualTo(productService.getProductById(2));
		
		/*
		 * Product product9=new Product(); product9.setId(1); product9.setName("pygg");
		 * given(productReposiory.findById(1)).willReturn(Optional.of(product9));
		 * productService.getProductById(2); assertThat(product9).isNotNull();
		 */
	}

	@Test
	public void whenFindAllbycategorybyid() {
		productService.getAllProductsByCategoryById(1);
		verify(productReposiory,times(1)).findAllByCategory_Id(1);
		/*
		 * Product pr = new Product(); pr.setId(1); List<Product> expectedDisplay =
		 * Arrays.asList(pr);
		 * doReturn(expectedDisplay).when(productReposiory).findAllByCategory_Id(1);
		 * List<Product> actualDisplay = productService.getAllProductsByCategoryById(1);
		 * assertThat(actualDisplay).isEqualTo(expectedDisplay);
		 */
	}

	@Test
	public void deletebyIdtest() {
		productService.removeProductById(1);
		verify(productReposiory, times(1)).deleteById(1);

	}

	
}
