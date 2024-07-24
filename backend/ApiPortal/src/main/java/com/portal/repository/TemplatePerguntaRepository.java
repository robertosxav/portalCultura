package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.TemplatePergunta;

@Repository
public interface TemplatePerguntaRepository extends JpaRepository<TemplatePergunta, Long>{ 
	
} 