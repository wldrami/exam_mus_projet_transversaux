package com.info.service;


import java.util.List;
import java.util.Optional;

import com.info.model.Marque;

public interface MarqueService {
	
public void addMarque(Marque marque);
	
	public List<Marque> listMarque();
	
	public void deleteMarque(long marqueId);
	
	public void updateMarque(Marque marque);
	
	public Optional<Marque> getMarque(long marqueId);
	
}
