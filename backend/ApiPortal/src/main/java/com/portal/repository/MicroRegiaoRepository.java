package com.portal.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.portal.model.MacroRegiao;
import com.portal.model.MicroRegiao;

@Repository
public interface MicroRegiaoRepository extends JpaRepository<MicroRegiao, Long>{

	@Query("SELECT mr FROM MicroRegiao mr"+
			 " where mr.status = 1"+
			 " and mr.macroRegiao.id = :idMacroRegiao ")
	List<MicroRegiao> listarMicroRegiaoPorMacroRegiao(Long idMacroRegiao); 
	
	@Query("SELECT mr FROM MacroRegiao mr "
			+ "WHERE mr.status = 1")
	Page<MacroRegiao> listarAtivosPaginado(Pageable pageable);

	@Query("SELECT mr FROM MacroRegiao mr "
			+ "WHERE mr.status = 1")
	List<MacroRegiao> listarAtivos(); 
	
} 