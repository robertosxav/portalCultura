package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.model.AreaCultural;

@Repository
public interface AreaCulturalRepository extends JpaRepository<AreaCultural, Long>{ 
	
	@Query("SELECT ac FROM AreaCultural ac "
			+ "WHERE ac.status = 1")
	Page<AreaCultural> listarAtivosPaginado(Pageable pageable);

	@Query("SELECT ac FROM AreaCultural ac "
			+ "WHERE ac.status = 1")
	List<AreaCultural> listarAtivos(); 
} 