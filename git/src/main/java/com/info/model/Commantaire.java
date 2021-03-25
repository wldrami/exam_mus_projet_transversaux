package com.info.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name = "Commantaire")
public class Commantaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commantaireId;
	
	@Column
	private String commantaireName;
	
	private String commantaireDescription;
	
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product product = new Product();
	
	
	

	
	public Commantaire() {
		this.commantaireName = "";
		this.commantaireDescription = "";
	}
	

	public long getCommantairetId() {
		return commantaireId;
	}

	public void setCommantaireId(long commantaireId) {
		this.commantaireId = commantaireId;
	}

	public String getCommantaireName() {
		return commantaireName;
	}

	public void setCommantaireName(String commantaireName) {
		this.commantaireName = commantaireName;
	}

	public String getCommantaireDescription() {
		return commantaireDescription;
	}

	public void setCommantaireDescription(String commantaireDescription) {
		this.commantaireDescription = commantaireDescription;
	}


	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
	
	
	

}
