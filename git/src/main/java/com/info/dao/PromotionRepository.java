package com.info.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.info.model.Promotion;
import com.info.model.User;
@Repository
public interface PromotionRepository  extends JpaRepository<Promotion, Long>{

}
