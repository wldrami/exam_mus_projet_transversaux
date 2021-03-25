package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.CommantaireRepository;
import com.info.model.Commantaire;

@Service
@Transactional
public class CommantaireServiceImpl implements CommantaireService{
	

	
	
	
	
	@Autowired
	private CommantaireRepository commantaireRepository;

	@Override
	public void addCommantaire(Commantaire commantaire) {
		commantaireRepository.save(commantaire);
	}
	
	@Override
	public List<Commantaire> listCommantaire() {
		return commantaireRepository.findAll();
	}

	@Override
	public Optional<Commantaire> getCommantaireById(long commantaireId) {
		return commantaireRepository.findById(commantaireId);
	}

	@Override
	public List<Commantaire> findByProduct(long productId) {
		return commantaireRepository.findByProduct_ProductId(productId);
	}
	
	
	 @Autowired
	    public void setCommantaireRepository(CommantaireRepository commantaireRepository) {
	        this.commantaireRepository = commantaireRepository;
	    }


	@Override
	public void deleteCommantaire(long commantaireId) {
		commantaireRepository.deleteById(commantaireId);
	}
	
	
	
	 @Override
	    public Iterable<Commantaire> listScommantBytName(String commantaireName) {
	        return commantaireRepository.findBycommantaireName(commantaireName);
	    }

	@Override
	public List<Commantaire> findByCommantaire(long commantaireId) {
		// TODO Auto-generated method stub
		return null;
	}
}
