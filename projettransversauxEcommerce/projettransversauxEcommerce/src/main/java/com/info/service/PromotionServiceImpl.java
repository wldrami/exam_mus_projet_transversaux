package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.info.dao.PromotionRepository;

import com.info.model.Promotion;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService{

	@Autowired
	private PromotionRepository promotionRepository;
	
	@Override
	public void addPromotion(Promotion promotion) {
		promotionRepository.save(promotion);
	}

	@Override
	public List<Promotion> listPromotion() {
		return promotionRepository.findAll();
	}

	@Override
	public void deletePromotion(long promotionId) {
		promotionRepository.deleteById(promotionId);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		promotionRepository.save(promotion);
	}

	@Override
	public Optional<Promotion> getPromotion(long promotionId) {
		return promotionRepository.findById(promotionId);
	}

}
