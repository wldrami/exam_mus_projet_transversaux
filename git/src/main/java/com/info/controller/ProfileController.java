package com.info.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.info.model.Commande;
import com.info.model.Product;
import com.info.model.User;


import com.info.service.ProductService;
import com.info.service.UserService;
import com.info.service.CommandeService;




@Controller
@RequestMapping("profile")
public class ProfileController {
	
	@Autowired
	private ProductService productService;
	
	
	@Autowired
	private CommandeService commandeService;



	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("cart-product")
	public ModelAndView cartProduct(Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cart-product");
		User user = userService.findByEmail(principal.getName());
		mv.addObject("user", user);
		int total = findSum(user);
		mv.addObject("total", total);
		return mv;
	}
	
	private int findSum(User user) {
		List<Product> list = user.getProductList();
		
		
		int sum =0;
		for(int i=0; i<list.size(); i++) {
			Product p = list.get(i);
			sum+= p.getProductPrice();
		}
		return sum;
		
	}
	
	@GetMapping("addToCart/{productId}")
	public ModelAndView addToCart(@PathVariable("productId")String productId,Principal principal) {
		ModelAndView mv = new ModelAndView("profile/cart-product");
		User user = userService.findByEmail(principal.getName());
	
		
		long productLongId = Long.parseLong(productId);
		Product product = productService.getProductById(productLongId).get();
		
		List<Product> productList = new ArrayList<Product>();
		productList.add(product);
		user.setProductList(productList);
		
		List<User> userList = new ArrayList<>();
		userList.add(user);
		product.setUserList(userList);
		
		
		
		
		
		userService.update(user);
		productService.addProduct(product);
		int total = findSum(user);
		mv.addObject("total", total);
		mv.addObject("user", user);
		return mv;
	}
	
	@GetMapping("delete-Product/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("profile/cart-product");
		productService.deleteProduct(Long.parseLong(productId));
		mv.addObject("productList", productService.listProduct());
		return mv;
		  
	}
	
	
//	For Commande--------------------------------------------------

	@GetMapping("Commande-form")
	public ModelAndView listCommande() {
		ModelAndView mv = new ModelAndView("profile/commande-form");
		mv.addObject("commandeList", commandeService.listCommande());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}

	@PostMapping("add-Commande")
	public ModelAndView addCommande(Commande commande) {
		ModelAndView mv = new ModelAndView("profile/commande-form");
		commandeService.addCommande(commande);
		mv.addObject("commandeList", commandeService.listCommande());
		return mv;
	}
	
	@GetMapping("delete-Commande/{commandeId}")
	public ModelAndView deleteCommande(@PathVariable("commandeId")String commandeId) {
		ModelAndView mv = new ModelAndView("profile/commande-form");
		commandeService.deleteCommande(Long.parseLong(commandeId));
		mv.addObject("commandeList", commandeService.listCommande());
		return mv;
	}
	
	@GetMapping("updateCommande/{commandeId}")
	public ModelAndView updateCommande(@PathVariable("commandeId")String commandeId) {
		ModelAndView mv = new ModelAndView("profile/updateCommande");
		mv.addObject("commandeList", commandeService.listCommande());
		mv.addObject("productList", productService.listProduct());
		mv.addObject("Commande", commandeService.getProductById(Long.parseLong(commandeId)).get());
		return mv;
	}
	
	

}