package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoRecurso;

@Repository
public interface ProjetoRecursoRepository extends JpaRepository<ProjetoRecurso, Long>{ 
	
} 