package com.info.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.info.dao.CommandeRepository;
import com.info.model.Commande;

@Service
@Transactional
public class CommandeServiceImpl implements CommandeService{

	@Autowired
	private CommandeRepository commandeRepository;
	
	@Override
	public void addCommande(Commande commande) {
		commandeRepository.save(commande);
	}

	@Override
	public List<Commande> listCommande() {
		return commandeRepository.findAll();
	}

	@Override
	public void deleteCommande(long commandeId) {
		commandeRepository.deleteById(commandeId);
	}

	@Override
	public void updateCommande(Commande commande) {
		commandeRepository.save(commande);
	}

	@Override
	public Optional<Commande> getProductById(long commandeId) {
		return commandeRepository.findById(commandeId);
	}

}
