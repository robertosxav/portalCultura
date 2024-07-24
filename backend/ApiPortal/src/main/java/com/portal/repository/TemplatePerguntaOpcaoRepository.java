package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.TemplatePerguntaOpcao;

@Repository
public interface TemplatePerguntaOpcaoRepository extends JpaRepository<TemplatePerguntaOpcao, Long>{ 
	
} 