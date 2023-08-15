package com.portal.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.Pessoa;

@Repository
public interface PessoaRepository extends JpaRepository<Pessoa, Long>{ 
	
	Optional<Pessoa> findByCpf(String cpf);
} 