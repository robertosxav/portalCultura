package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.LeiEditalFormulario;

@Repository
public interface LeiEditalFormularioRepository extends JpaRepository<LeiEditalFormulario, Long>{ 
	
} 