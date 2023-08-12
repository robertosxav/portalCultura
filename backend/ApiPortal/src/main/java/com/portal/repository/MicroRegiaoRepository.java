package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.MicroRegiao;

@Repository
public interface MicroRegiaoRepository extends JpaRepository<MicroRegiao, Long>{ 
	
} 