package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.AcaoCategoria;

@Repository
public interface AcaoCategoriaRepository extends JpaRepository<AcaoCategoria, Long>{ 
	
} 