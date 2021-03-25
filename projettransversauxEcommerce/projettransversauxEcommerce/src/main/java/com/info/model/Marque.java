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
@Table(name = "marque")
public class Marque {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long marqueId;
	
	private String marqueName;
	
	@OneToMany(mappedBy = "marque", cascade = CascadeType.ALL)
	private List<Product> productList;

	public long getMarqueId() {
		return marqueId;
	}

	public void setMarqueId(long marqueId) {
		this.marqueId = marqueId;
	}

	public String getMarqueName() {
		return marqueName;
	}

	public void setMarqueName(String marqueName) {
		this.marqueName = marqueName;
	}

	public List<Product> getProductList() {
		return productList;
	}

	public void setProductList(List<Product> productList) {
		this.productList = productList;
	}

}
