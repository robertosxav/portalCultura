package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoEquipe;

@Repository
public interface ProjetoEquipeRepository extends JpaRepository<ProjetoEquipe, Long>{ 
	
} 