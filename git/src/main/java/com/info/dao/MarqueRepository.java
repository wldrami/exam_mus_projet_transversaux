package com.info.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Marque;

@Repository
public interface MarqueRepository extends JpaRepository<Marque, Long>{
}
