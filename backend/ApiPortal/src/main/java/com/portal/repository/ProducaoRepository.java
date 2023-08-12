package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.Producao;

@Repository
public interface ProducaoRepository extends JpaRepository<Producao, Long>{ 
	
} 