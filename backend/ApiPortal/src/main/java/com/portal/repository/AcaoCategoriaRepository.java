package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.portal.model.AcaoCategoria;

@Repository
public interface AcaoCategoriaRepository extends JpaRepository<AcaoCategoria, Long>{
	
	@Query("SELECT ac FROM AcaoCategoria ac "
			+ "WHERE ac.status = 1")
	Page<AcaoCategoria> listarAtivosPaginado(Pageable pageable);

	@Query("SELECT ac FROM AcaoCategoria ac "
			+ "WHERE ac.status = 1")
	List<AcaoCategoria> listarAtivos(); 
	
} 