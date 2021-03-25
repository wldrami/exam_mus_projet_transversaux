package com.info.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Commantaire;

@Repository
public interface CommantaireRepository extends JpaRepository<Commantaire, Long>{
	
	public List<Commantaire> findByProduct_ProductId(long ProductId);
	
    Iterable<Commantaire> findBycommantaireName(String commantaireName);
  
   

}
