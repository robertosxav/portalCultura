package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.ProjetoCoordenador;

@Repository
public interface ProjetoCoordenadorRepository extends JpaRepository<ProjetoCoordenador, Long>{ 
	
} 