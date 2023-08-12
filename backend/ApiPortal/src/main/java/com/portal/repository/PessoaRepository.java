package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{ 
	
} 