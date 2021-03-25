package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Product;


public interface ProductService {

	public void addProduct(Product product);

	public List<Product> listProduct();
	
	public Optional<Product> getProductById(long productId);
	
	
	public List<Product> findByPromotion(long promotionId);
	
	public List<Product> findByCategory(long categoryId);
	
	public List<Product> findByMarque(long marqueId);
	
	public List<Product>  findByProduct(long productId);
	
	public void deleteProduct(long productId);

	 Iterable<Product> listSproducBytName(String productName);
	
	
}
	

