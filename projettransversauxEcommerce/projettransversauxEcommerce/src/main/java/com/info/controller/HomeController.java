package com.info.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Commantaire;
import com.info.model.Product;
import com.info.model.User;
import com.info.service.CategoryService;
import com.info.service.ProductService;
import com.info.service.UserService;
import com.info.service.CommantaireService;


import org.springframework.data.repository.query.Param;

import org.springframework.web.bind.annotation.RequestMethod;




@Controller
@RequestMapping("/")
public class HomeController {
	
	
	
	
	
	
	
	@Autowired
	private CommantaireService commantaireService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ProductService productService;
	
	@GetMapping({"index", "/"})
	public String index(Model model) {
		model.addAttribute("categoryList", categoryService.listCategory());
		model.addAttribute("productList", productService.listProduct());
		model.addAttribute("commantaireList", commantaireService.listCommantaire());
		return "index";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	
	@GetMapping("signup")
	public String signup() {
		return "signup";
	}
	
	@GetMapping("chekout")
	public String chekout() {
		return "chekout";
	}
	@GetMapping("Produit")
	public String Produit() {
		return "Produit";
	}
	
	@GetMapping("Commantaire")
	public String Commantaire() {
		return "Commantaire";
	}
	
	

	@GetMapping("contacter")
	public String contacter() {
		return "contacter";
	}

	@Autowired
    public void setProduitService(ProductService productService) {
        this.productService = productService;
    }
	
	@Autowired
    public void setCommantaireService(CommantaireService commantaireService) {
        this.commantaireService = commantaireService;
    }

    @RequestMapping(value = "products/{productName}", method = RequestMethod.GET)
    public String showStudentBySurname(@PathVariable String productName, Model model) {
    	
    	List<Product> listeProduit = (List<Product>) productService.listSproducBytName(productName);
    	
    	model.addAttribute("categoryList", categoryService.listCategory());
		model.addAttribute("productList", listeProduit);
		return "index";
    }
	
	
	
    @RequestMapping(value = "Commantaires/{commantaireName}", method = RequestMethod.GET)
    public String showCommantaireBySurname(@PathVariable String commantaireName, Model model) {
    	
    	List<Commantaire> listeCommantaire = (List<Commantaire>) commantaireService.listScommantBytName(commantaireName);
    	
    	model.addAttribute("productList", productService.listProduct());
		model.addAttribute("commantaireList", listeCommantaire);
		return "index";
    }
	
	

	@RequestMapping("/")
	public String viewHomePage(Model model, @Param("keyword") String keyword) {
	
	
		model.addAttribute("keyword", keyword);
		
		return "index";
	}
	
	

	
	
	@PostMapping("signup")
	public ModelAndView signUp(User user) {
		ModelAndView mv = new ModelAndView("/index");
		userService.save(user);
		mv.addObject("productList", productService.listProduct());
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("allProduct")
	public String allProduct(Model model) {
		model.addAttribute("productList", productService.listProduct());
		model.addAttribute("categoryList", categoryService.listCategory());
		return "index";
	}
	

	
	
	@GetMapping("allCommantaire")
	public String allCommantaire(Model model) {
		model.addAttribute("commantaireList", commantaireService.listCommantaire());
		model.addAttribute("productList", productService.listProduct());
		return "index";
	}
	

	
	
	
	
	
	
	@GetMapping("getProducts/{categoryId}")
	public ModelAndView getProductFromCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("index");
		long categoryLongId = Long.parseLong(categoryId);
		System.out.println(categoryLongId);
		mv.addObject("productList", productService.findByCategory(categoryLongId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	
	@GetMapping("getCommantaires/{productId}")
	public ModelAndView getProductFromProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("index");
		long productLongId = Long.parseLong(productId);
		System.out.println(productLongId);
		mv.addObject("commantaireList", commantaireService.findByProduct(productLongId));
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	
	
	
	
	
	
	
	
	@GetMapping("getPro/{productId}")
	public ModelAndView getProductFrom(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("Produit");
		long productLongId = Long.parseLong(productId);
		System.out.println(productLongId);
		mv.addObject("productList", productService.findByProduct(productLongId));
		mv.addObject("categoryList", productService.listProduct());
		return 	mv;
	}
	
	
	
	@GetMapping("getCom/{commantaireId}")
	public ModelAndView getCommantaireFrom(@PathVariable("commantairetId")String commantaireId) {
		ModelAndView mv = new ModelAndView("Produit");
		long commantaireLongId = Long.parseLong(commantaireId);
		System.out.println(commantaireLongId);
		mv.addObject("commantaireList", commantaireService.findByCommantaire(commantaireLongId));
		mv.addObject("productList", commantaireService.listCommantaire());
		return 	mv;
	}
	
	
	
	@GetMapping("error")
	public String error() {
		return "error";
	}
	
	
	@PostMapping("add-commantaire")
	public ModelAndView addCommantaire(Commantaire commantaire) {
		ModelAndView mv = new ModelAndView("index");
		commantaireService.addCommantaire(commantaire);
		mv.addObject("commantaireList", commantaireService.listCommantaire());
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	


	@GetMapping("commantaire-form")
	public ModelAndView listCommantaire() {
		ModelAndView mv = new ModelAndView("index");
		
		mv.addObject("commantaireList", commantaireService.listCommantaire());
		
		
		return mv;
	}
	

	
}
