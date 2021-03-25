package com.info.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "promotion")
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long promotionId;
	
	private String promotionName;
	
	private int promotionPourcentage;
	
	@OneToMany(mappedBy = "promotion", cascade = CascadeType.ALL)
	private List<Product> productList;

	public long getPromotionId() {
		return promotionId;
	}

	public void setPromotionId(long promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public int getPromotionPourcentage() {
		return promotionPourcentage;
	}

	public void setPromotionPourcentage(int promotionPourcentage) {
		this.promotionPourcentage = promotionPourcentage;
	}
	
	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
