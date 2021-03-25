package com.info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.info.model.Category;
import com.info.model.Marque;
import com.info.model.Promotion;
import com.info.model.Product;


import com.info.service.CategoryService;
import com.info.service.PromotionService;
import com.info.service.MarqueService;
import com.info.service.FileUploadService;
import com.info.service.ProductService;




@Controller
@RequestMapping("manager")
public class ManagerController {

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private PromotionService promotionService;
	
	
	@Autowired
	private MarqueService marqueService;
	
	
	
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileUploadService fileUploadService;

	@GetMapping("index")
	public String index() {
		return "manager/index";
	}

//	For Category--------------------------------------------------
	@GetMapping("category-form")
	public ModelAndView listCategory() {
		ModelAndView mv = new ModelAndView("manager/category-form");
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}

	@PostMapping("add-category")
	public ModelAndView addCategory(Category category) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.addCategory(category);
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("delete-Category/{categoryId}")
	public ModelAndView deleteCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/category-form");
		categoryService.deleteCategory(Long.parseLong(categoryId));
		mv.addObject("categoryList", categoryService.listCategory());
		return mv;
	}
	
	@GetMapping("updateCategory/{categoryId}")
	public ModelAndView updateCategory(@PathVariable("categoryId")String categoryId) {
		ModelAndView mv = new ModelAndView("manager/updateCategory");
		mv.addObject("Category", categoryService.getCategory(Long.parseLong(categoryId)).get());
		return mv;
	}
	
	
	
	
	
	
	
	
	
	
//	For Marque--------------------------------------------------
	@GetMapping("marque-form")
	public ModelAndView listMarque() {
		ModelAndView mv = new ModelAndView("manager/marque-form");
		mv.addObject("marqueList", marqueService.listMarque());
		return mv;
	}
	
	
	
	
	@PostMapping("add-marque")
	public ModelAndView addMarque(Marque marque) {
		ModelAndView mv = new ModelAndView("manager/marque-form");
		marqueService.addMarque(marque);
		mv.addObject("marqueList", marqueService.listMarque());
		return mv;
	}
	
	@GetMapping("delete-Marque/{marqueId}")
	public ModelAndView deleteMarque(@PathVariable("marqueId")String marqueId) {
		ModelAndView mv = new ModelAndView("manager/marque-form");
		marqueService.deleteMarque(Long.parseLong(marqueId));
		mv.addObject("marqueList", marqueService.listMarque());
		return mv;
	}
	
	@GetMapping("updateMarque/{marqueId}")
	public ModelAndView updateMarque(@PathVariable("marqueId")String marqueId) {
		ModelAndView mv = new ModelAndView("manager/updateMarque");
		mv.addObject("Marque", marqueService.getMarque(Long.parseLong(marqueId)).get());
		return mv;
	}
//	For Category--------------------------------------------------
	@GetMapping("promotion-form")
	public ModelAndView listPromotion() {
		ModelAndView mv = new ModelAndView("manager/promotion-form");
		mv.addObject("promotionList", promotionService.listPromotion());
		return mv;
	}

	@PostMapping("add-promotion")
	public ModelAndView addPromotion(Promotion promotion) {
		ModelAndView mv = new ModelAndView("manager/promotion-form");
		promotionService.addPromotion(promotion);
		mv.addObject("promotionList", promotionService.listPromotion());
		return mv;
	}
	
	@GetMapping("delete-Promotion/{promotionId}")
	public ModelAndView deletePromotion(@PathVariable("promotionId")String promotionId) {
		ModelAndView mv = new ModelAndView("manager/promotion-form");
		promotionService.deletePromotion(Long.parseLong(promotionId));
		mv.addObject("promotionList", promotionService.listPromotion());
		return mv;
	}
	
	@GetMapping("updatePromotion/{promotionId}")
	public ModelAndView updatePromotion(@PathVariable("promotionId")String promotionId) {
		ModelAndView mv = new ModelAndView("manager/updatePromotion");
		mv.addObject("promotion", promotionService.getPromotion(Long.parseLong(promotionId)).get());
		return mv;
	}
	
	
	
//	For Product--------------------------------------------------
	@GetMapping("product-form")
	public ModelAndView listProduct() {
		ModelAndView mv = new ModelAndView("manager/product-form");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("marqueList", marqueService.listMarque());
		mv.addObject("promotionList", promotionService.listPromotion());
		mv.addObject("productList", productService.listProduct());
		
		return mv;
	}

	@PostMapping("add-product")
	public ModelAndView addProduct(Product product, @RequestParam("file") MultipartFile file) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		System.out.println("file: " + file.getOriginalFilename());
		String filePath = fileUploadService.upload(file);
		product.setImage(filePath);
		
		System.out.println(product.getImage());
		
		productService.addProduct(product);
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("delete-Product/{productId}")
	public ModelAndView deleteProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/product-form");
		productService.deleteProduct(Long.parseLong(productId));
		mv.addObject("productList", productService.listProduct());
		return mv;
	}
	
	@GetMapping("updateProduct/{productId}")
	public ModelAndView updateProduct(@PathVariable("productId")String productId) {
		ModelAndView mv = new ModelAndView("manager/updateProduct");
		mv.addObject("categoryList", categoryService.listCategory());
		mv.addObject("marqueList", marqueService.listMarque());
		mv.addObject("PromotionList", promotionService.listPromotion());
		mv.addObject("Product", productService.getProductById(Long.parseLong(productId)).get());
		return mv;
	}
	
	
	



	

}
