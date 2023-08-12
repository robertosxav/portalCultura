package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoAbrangencia;

@Repository
public interface ProjetoAbrangenciaRepository extends JpaRepository<ProjetoAbrangencia, Long>{ 
	
} 