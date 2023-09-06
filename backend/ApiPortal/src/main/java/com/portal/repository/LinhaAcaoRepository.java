package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.portal.model.LinhaAcao;

@Repository
public interface LinhaAcaoRepository extends JpaRepository<LinhaAcao, Long>{

	@Query("SELECT la FROM LinhaAcao la "
			+ "WHERE la.status = 1")
	Page<LinhaAcao> listarAtivosPaginado(Pageable pageable);

	@Query("SELECT la FROM LinhaAcao la "
			+ "WHERE la.status = 1")
	List<LinhaAcao> listarAtivos(); 
	
} 