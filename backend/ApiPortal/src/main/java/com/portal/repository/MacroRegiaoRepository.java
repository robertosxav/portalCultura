package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.MacroRegiao;

@Repository
public interface MacroRegiaoRepository extends JpaRepository<MacroRegiao, Long>{ 
	
} 