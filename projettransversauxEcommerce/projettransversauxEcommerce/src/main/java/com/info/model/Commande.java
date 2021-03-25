package com.info.model;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Commande")
public class Commande {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long commandeId;
	
	private String commandeRef;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "product_id")
	private Product product = new Product();

	public long getcommandeId() {
		return commandeId;
	}

	public void setcommandeId(long commandeId) {
		this.commandeId = commandeId;
	}

	public String getcommandeRef() {
		return commandeRef;
	}

	public void setcommandeRef(String commandeRef) {
		this.commandeRef = commandeRef;
	}
	
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
