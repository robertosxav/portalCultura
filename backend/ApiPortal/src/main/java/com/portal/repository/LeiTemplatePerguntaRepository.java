package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.LeiTemplatePergunta;

@Repository
public interface LeiTemplatePerguntaRepository extends JpaRepository<LeiTemplatePergunta, Long>{ 
	
} 