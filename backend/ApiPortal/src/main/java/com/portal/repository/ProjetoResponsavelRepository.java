package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoResponsavel;

@Repository
public interface ProjetoResponsavelRepository extends JpaRepository<ProjetoResponsavel, Long>{ 
	
} 