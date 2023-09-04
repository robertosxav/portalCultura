package com.portal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoAbrangencia;

@Repository
public interface ProjetoAbrangenciaRepository extends JpaRepository<ProjetoAbrangencia, Long>{

	@Query("SELECT pa FROM ProjetoAbrangencia pa"
			+ " where pa.projeto.id = :idProjeto")
	List<ProjetoAbrangencia> listarPorProjeto(Long idProjeto); 
	
} 