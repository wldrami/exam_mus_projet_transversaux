package com.info.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "product")
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long productId;
	
	@Column
	private String productName;
	
	private String productDescription;
	
	@Column
	private Float productPrice;
	
	@Column
	private int productUnit;
	
	private String image;


	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "category_id")
	private Category category = new Category();
	
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "marque_id")
	private Marque marque = new Marque();
	
	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "promotion_id")
	private Promotion promotion = new Promotion();

	@ManyToMany(mappedBy = "productList",fetch = FetchType.EAGER)
	private List<User> userList;
	
	public Product() {
		this.productName = "";
		this.productDescription = "";
	}
	

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Float getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Float productPrice) {
		this.productPrice = productPrice;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}
	
	
	

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	
	public Marque getMarque() {
		return marque;
	}

	public void setMarque(Marque marque) {
		this.marque = marque;
	}
	
	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}
	
	public List<User> getUserList() {
		return userList;
	}

	public void setUserList(List<User> userList) {
		this.userList = userList;
	}

	public int getProductUnit() {
		return productUnit;
	}

	public void setProductUnit(int productUnit) {
		this.productUnit = productUnit;
	}
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Commande> commandeList;
	
	public List<Commande> getCommandeList() {
		return commandeList;
	}

	public void setCommandeList(List<Commande> commandeList) {
		this.commandeList = commandeList;
	}

	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private List<Commantaire> commantaireList;


	public List<Commantaire> getCommantaireList() {
		return commantaireList;
	}

	public void setCommantaireList(List<Commantaire> commantaireList) {
		this.commantaireList = commantaireList;
	}

	
	
}
