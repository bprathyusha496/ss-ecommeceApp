package com.rgt.app.serviceTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.repository.CategoryRepository;
import com.rgt.app.service.CategoryService;

@ExtendWith(MockitoExtension.class)
@SpringBootTest
public class CategoryServiceTest {  
	@InjectMocks
	private CategoryService categoryService;
	@Mock
	private CategoryRepository categoryRepository; 
	
	@Test
	public void savecategoryTest() { 
		Category category=new Category();
		category.setName("asdf");
		Mockito.when(categoryRepository.save(category)).thenReturn(category);
		categoryService.addCategory(category); 
	}
	
	@Test
	public void whenFindAll_thenReturnCategoryList() {

	Category c=new Category();
	c.setId(1);

	    List<Category> expectedDisplay = Arrays.asList(c);
	    doReturn(expectedDisplay).when(categoryRepository).findAll();
	    List<Category> actualDisplay = categoryService.getallCategory();
	    assertThat(actualDisplay).isEqualTo(expectedDisplay);
	    
	} 
	
	@Test
	public void getByProductid() {
		Category cat=new Category();
		cat.setId(1); 
		
		given(categoryRepository.findById(1)).willReturn(Optional.of(cat));
		categoryService.getCategoryById(1);
		assertThat(cat).isNotNull();

	}
	

	@Test
	public void deletebyIdtest() {
		categoryService.removeCategoryById(1);
		verify(categoryRepository, times(1)).deleteById(1);

	}
}


