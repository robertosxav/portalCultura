package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.LeiTemplatePerguntaOpcao;

@Repository
public interface LeiTemplatePerguntaOpcaoRepository extends JpaRepository<LeiTemplatePerguntaOpcao, Long>{ 
	
} 