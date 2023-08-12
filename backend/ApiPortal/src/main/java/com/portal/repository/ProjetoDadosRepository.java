package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoDados;

@Repository
public interface ProjetoDadosRepository extends JpaRepository<ProjetoDados, Long>{ 
	
} 