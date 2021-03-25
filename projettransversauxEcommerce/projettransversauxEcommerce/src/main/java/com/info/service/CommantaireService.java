package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Commantaire;

public interface CommantaireService {

	public void addCommantaire(Commantaire commantaire);

	public List<Commantaire> listCommantaire();
	
	public Optional<Commantaire> getCommantaireById(long commantaireId);
	
	
	
	
	public List<Commantaire> findByProduct(long productId);
	
	
	
	public List<Commantaire>  findByCommantaire(long commantaireId);
	
	public void deleteCommantaire(long commantaireId);

	 Iterable<Commantaire> listScommantBytName(String commantaireName);
	
	
}
	

