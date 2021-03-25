package com.info.service;

import java.util.List;
import java.util.Optional;

import com.info.model.Promotion;


public interface PromotionService {
	
public void addPromotion(Promotion promotion);
	


	public List<Promotion> listPromotion();
	
	public void deletePromotion(long promotionId);
	
	public void updatePromotion(Promotion promotion);
	
	public Optional<Promotion> getPromotion(long promotionId);
}
