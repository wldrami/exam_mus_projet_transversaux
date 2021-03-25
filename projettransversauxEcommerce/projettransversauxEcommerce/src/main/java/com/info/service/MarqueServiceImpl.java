package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.info.dao.MarqueRepository;

import com.info.model.Marque;

@Service
@Transactional
public class MarqueServiceImpl implements MarqueService{
	

	@Autowired
	private MarqueRepository marqueRepository;
	
	@Override
	public void addMarque(Marque marque) {
		marqueRepository.save(marque);
	}

	@Override
	public List<Marque> listMarque() {
		return marqueRepository.findAll();
	}

	@Override
	public void deleteMarque(long marqueId) {
		marqueRepository.deleteById(marqueId);
	}

	@Override
	public void updateMarque(Marque marque) {
		marqueRepository.save(marque);
	}

	@Override
	public Optional<Marque> getMarque(long marqueId) {
		return marqueRepository.findById(marqueId);
	}
}
