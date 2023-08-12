package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoPlanoDist;

@Repository
public interface ProjetoPlanoDistRepository extends JpaRepository<ProjetoPlanoDist, Long>{ 
	
} 