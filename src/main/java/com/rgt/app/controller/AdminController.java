package com.rgt.app.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rgt.app.dto.ProductDTO;
import com.rgt.app.models.Category;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.CategoryService;
import com.rgt.app.service.ProductService;

@Controller
public class AdminController {
 
	private static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/productImages";
  
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;

	@Autowired
	ReceiptRepositoy receiptRepositoy;

	@Autowired
	UserRepository userRepository;
	
	@GetMapping("/admin")
	public String adminHome() { 
		return "adminHome";
	}
	@GetMapping("/admin/categories")
	public String getCategories(Model model) {
		List<Category> ss = categoryService.getallCategory();
		model.addAttribute("categories", ss);
		return "categories";
	}
	@GetMapping("/admin/categories/add")
	public String getCategoriesAdd(Model model) { 
		model.addAttribute("category", new Category());
		return "categoriesAdd";
		
	}

	@PostMapping("/admin/categories/add")
	public String postCatAdd(@ModelAttribute("category") Category category) {
		categoryService.addCategory(category);
		return "redirect:/admin/categories";
	}

	@GetMapping("/admin/categories/delete/{id}")
	public String deleteCat(@PathVariable int id) {
		categoryService.removeCategoryById(id);
		return "redirect:/admin/categories";
	} 

	@GetMapping("/admin/categories/update/{id}") 
	public String updateCat(@PathVariable int id, Model model) {

		Optional<Category> category = categoryService.getCategoryById(id);
		if (category.isPresent()) {
			model.addAttribute("category", category.get());
			return "categoriesAdd";
		} else {
			return "exception 404";
		} 
	}
	// products section
	// product save 
	
	@GetMapping("/admin/products")
	public String productsinfo(Model model) {
		List<Product> p = productService.getallProducts();
		model.addAttribute("products", p);
		return "products";
	}

	@GetMapping("/admin/products/add")
	public String ProductsAddGet(Model model) {
		model.addAttribute("productDTO", new ProductDTO());
		model.addAttribute("categories", categoryService.getallCategory());
		return "productsAdd";
	}

	@PostMapping("/admin/products/add")
	public String productAddPost(@ModelAttribute("productDTO") ProductDTO productDTO,
	@RequestParam("productImage") MultipartFile file, @RequestParam("imgName") String imgName) throws IOException {
		Product product = new Product();
		product.setId(productDTO.getId());
		product.setName(productDTO.getName());
	//	product.setCategory(categoryService.getCategoryById(productDTO.getCategoryId()).get());  //copmment for testing
		product.setPrice(productDTO.getPrice());
		product.setWeight(productDTO.getWeight());
		product.setDescription(productDTO.getDescription());

		String imageUUID;

		if (!file.isEmpty()) { 
			imageUUID = file.getOriginalFilename();
			Path fileNameAndpath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndpath, file.getBytes());
		} else {
			imageUUID = imgName;
		}
		product.setImageName(imageUUID);
		productService.addProduct(product);
		return "redirect:/admin/products";
	}

	// product delete
	@GetMapping("/admin/product/delete/{id}")
	public String deleteProduct(@PathVariable int id) {
		productService.removeProductById(id);
		return "redirect:/admin/products";  

	}
	// product update
	@GetMapping("/admin/product/update/{id}")
	public String uploadProductGet(@PathVariable int id, Model model) {
		Product product = productService.getProductById(id).get();
		ProductDTO productDTO = new ProductDTO();
		productDTO.setId(product.getId());
		productDTO.setName(product.getName());
		productDTO.setCategoryId(product.getCategory().getId());
		productDTO.setPrice(product.getPrice());
		productDTO.setWeight(product.getWeight());
		productDTO.setDescription(product.getDescription());
		productDTO.setImageName(product.getImageName());

		model.addAttribute("categories", categoryService.getallCategory());
		model.addAttribute("productDTO", productDTO); 
		return "productsAdd";

	}

	/*
	 * {UUID :- A universally unique identifier (UUID) is a 128-bit label used for
	 * information in computer systems. The term globally unique identifier (GUID)
	 * is also used. Universally unique identifier.}
	 */

	@GetMapping("/getalluserOrders")
	public String getallUserOders(@ModelAttribute Receipt receipt, Principal principal, Model model) {

		List<Receipt> all = receiptRepositoy.findAll();
		model.addAttribute("receipt", all);
		return "getallOrderbyuser"; 

	}

}
