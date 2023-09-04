package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.model.ProjetoDados;

@Repository
public interface ProjetoDadosRepository extends JpaRepository<ProjetoDados, Long>{

	@Query("SELECT pd FROM ProjetoDados pd "
			+ "where pd.projeto.id = :idProjeto")
	List<ProjetoDados> listarPorProjeto(Long idProjeto); 
	
} 