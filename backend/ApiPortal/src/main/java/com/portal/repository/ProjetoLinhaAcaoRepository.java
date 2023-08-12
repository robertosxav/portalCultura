package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoLinhaAcao;

@Repository
public interface ProjetoLinhaAcaoRepository extends JpaRepository<ProjetoLinhaAcao, Long>{ 
	
} 