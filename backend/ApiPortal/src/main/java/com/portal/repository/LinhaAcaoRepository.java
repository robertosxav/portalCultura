package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.LinhaAcao;

@Repository
public interface LinhaAcaoRepository extends JpaRepository<LinhaAcao, Long>{ 
	
} 