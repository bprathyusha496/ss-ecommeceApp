package com.rgt.app.controller;

import java.security.Principal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.rgt.app.global.GlobalData;
import com.rgt.app.models.Address;
import com.rgt.app.models.Product;
import com.rgt.app.models.Receipt;
import com.rgt.app.models.User;
import com.rgt.app.repository.ProductReposiory;
import com.rgt.app.repository.ReceiptRepositoy;
import com.rgt.app.repository.UserRepository;
import com.rgt.app.service.AddressService;
import com.rgt.app.service.ProductService;

@Controller
public class CartController {
	@Autowired
	private ProductService productService;
	@Autowired
	private AddressService addressService;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	ProductReposiory productReposiory;
	@Autowired
	ReceiptRepositoy receiptRepositoy;

	@GetMapping("/addToCart/{id}") 
	public String addToCart(@PathVariable int id, Model model, Principal principal) {
		User user = userRepository.findByemail(principal.getName());
		Receipt uu = new Receipt();
		uu.setConfirm("pending");
		uu.setProductId(id);

		uu.setUser(user.getId());
		receiptRepositoy.save(uu);
		GlobalData.cart.add(productService.getProductById(id).get());
		return "redirect:/shop";
	}

	/*
	 * @GetMapping("/cart") public String cartGet(Model model) {
	 * model.addAttribute("cartCount", GlobalData.cart.size());
	 * model.addAttribute("total",
	 * GlobalData.cart.stream().mapToDouble(Product::getPrice).sum()); Double total
	 * = GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
	 * System.out.println(total); model.addAttribute("cart", GlobalData.cart);
	 * return "cart"; }
	 */
	@GetMapping("/cart")
	public String cartGet(Model model, Principal principal) {
		
		model.addAttribute("cart", GlobalData.cart);
		List<Product> pr = productReposiory.findAll();

		User objj = userRepository.findByemail(principal.getName());
		List<Receipt> receipt = receiptRepositoy.findAll();
		
		for (Receipt re : receipt) {
			for (Product p : pr) {
				if (re.getConfirm().equals("pending") && re.getUser() == (objj.getId())&& re.getProductId() == p.getId()) {
					GlobalData.cart.add(productService.getProductById(p.getId()).get());

					model.addAttribute("cart", GlobalData.cart);
					model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
					Double total = GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
					System.out.println(total);
					model.addAttribute("cartCount", GlobalData.cart.size());
				}

			}
		}
		/*
		 * for (Receipt re : receipt) { for (Product p : pr) { if
		 * (re.getConfirm().equals("pending") && re.getUser() == (objj.getId()) &&
		 * re.getProductId() == p.getId()) {
		 * productService.getProductById(p.getId()).get(); } else {
		 * GlobalData.cart.clear(); } }
		 * 
		 * }
		 */
		return "cart";
	}

	@GetMapping("/yourorders")
	public String cartGet1(Model model, Principal principal) {
		model.addAttribute("cart", GlobalData.cart);
		List<Product> pr = productReposiory.findAll();

		User objj = userRepository.findByemail(principal.getName());
		List<Receipt> receipt = receiptRepositoy.findAll();
		
		for (Receipt re : receipt) {
			for (Product p : pr) {
		if (re.getUser() == (objj.getId())&& re.getProductId() == p.getId()) {
			GlobalData.cart.add(productService.getProductById(p.getId()).get());
					
				}

			}}
		

		return "Orders";
	}

	/*
	 * @GetMapping("/cart") public String cartGet(Model model, Principal principal)
	 * {
	 * 
	 * model.addAttribute("cartCount", GlobalData.cart.size());
	 * model.addAttribute("total",
	 * GlobalData.cart.stream().mapToDouble(Product::getPrice).sum()); Double total=
	 * GlobalData.cart.stream().mapToDouble(Product::getPrice).sum();
	 * System.out.println(total); model.addAttribute("orders", GlobalData.cart);
	 * 
	 * List<Product> pr = productReposiory.findAll(); User objj
	 * =userRepository.findByemail(principal.getName()); List<Receipt> receipt
	 * =receiptRepositoy.findAll(); for (Receipt re : receipt) { for (Product p :
	 * pr){ if (re.getUser() == (objj.getId()) && re.getProductId() == p.getId()) {
	 * GlobalData.cart.add(productService.getProductById(p.getId()).get());
	 * model.addAttribute("status",re.getConfirm()); //
	 * model.addAttribute("cart",GlobalData.cart); } } } return "orders"; }
	 */
	@GetMapping("/cart/removeItem/{index}")
	public String cartItemRemove(@PathVariable int index) {
		GlobalData.cart.remove(index);
		return "redirect:/cart";
	}

	/*
	 * @GetMapping("/cart/removeItem1/{id}") public String
	 * cartItemRemove1(@PathVariable int id) {
	 * 
	 * 
	 * Product prod=productReposiory.findById(id).get(); User objj =
	 * userRepository.findByemail(principal.getName()); prod.setUser(objj);
	 * 
	 * Receipt ep = new Receipt(); ep.setReceiptid(id); receiptRepositoy.save(id);
	 * receiptRepositoy.deleteById(id); return "redirect:/cart"; }
	 */

	@GetMapping("/cart/addItem/{id}")
	public String cartItemadd(@PathVariable int id, Principal principal) {
		System.out.println(principal.getName());
		User objj = userRepository.findByemail(principal.getName());
		Product pd = productReposiory.findById(id).get();
		pd.setUser(objj);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDateTime now = LocalDateTime.now();
		System.out.println(now);
		List<Receipt> receipt = receiptRepositoy.findAll();
		for (Receipt u : receipt) {
			if (u.getUser() == (objj.getId()) && u.getProductId() == id && u.getConfirm().equals("pending")) {
				u.setName(pd.getName());
				u.setImageName(pd.getImageName());
				u.setPrice(pd.getPrice());
				u.setDescription(pd.getDescription());
				u.setWeight(pd.getWeight());
				u.setCategory(pd.getCategory().getId() + " ");
				u.setEmail(objj.getEmail());
				u.setOrderDate(now);
				u.setConfirm("confirm");
				u.setDeliveredDate(now.plusDays(5));
				int i = 0;
				u.setStatusId(i);

				receiptRepositoy.save(u);
				break;

			}

		}

		return "redirect:/cart";
	}

	@GetMapping("/checkout")
	public String checkout(Model model, Principal principal) {
		model.addAttribute("cart", GlobalData.cart);
		int i = 0;

		User objj = userRepository.findByemail(principal.getName());
		List<Receipt> receipt = receiptRepositoy.findAll();
		for (Receipt u : receipt) {

			if (u.getUser() == ((objj.getId())) && u.getConfirm().equals("pending")) {

				i = 10;

			}
		}
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("cart", GlobalData.cart);
		if (i == 10) {

			return "cart";
		} else { 
			return "checkout";
		}
	}
	@PostMapping("/checkout")
	public String checkout1(@Valid Model model, Principal principal) {

		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("cart", GlobalData.cart);
		Receipt r = new Receipt();
		r.setDeliveredDate(r.getOrderDate().plusDays(5));
		model.addAttribute("check");

		return "checkout";
	}

	@PostMapping("/success")
	public String sucessmethod(@Valid Model model, @ModelAttribute("address") Address address, Principal principal,
			Product product) {
		model.addAttribute("total", GlobalData.cart.stream().mapToDouble(Product::getPrice).sum());
		model.addAttribute("cartCount", GlobalData.cart.size());
		model.addAttribute("price", GlobalData.cart.stream().mapToDouble(Product::getPrice));
		model.addAttribute("cart", GlobalData.cart);
		model.addAttribute("productName", GlobalData.cart.stream().map(Product::getName));

		List<Receipt> fi = receiptRepositoy.findAll();
		for (Receipt f : fi) {
			model.addAttribute("DeliveryDate", f.getDeliveredDate());
		}

		addressService.saveaddress(address);  

		return "success";

	}

}
