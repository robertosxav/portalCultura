package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoAnexos;

@Repository
public interface ProjetoAnexosRepository extends JpaRepository<ProjetoAnexos, Long>{ 
	
} 