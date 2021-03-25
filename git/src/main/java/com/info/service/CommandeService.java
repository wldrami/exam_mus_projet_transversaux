package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Commande;


public interface CommandeService {
public void addCommande(Commande commande);
	
	public List<Commande> listCommande();
	
	public void deleteCommande(long commandeId);
	
	public void updateCommande(Commande commande);
	
	public Optional<Commande> getProductById(long commandeId);
	

	
}
