package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.portal.model.Edital;

@Repository
public interface EditalRepository extends JpaRepository<Edital, Long>{ 
	
} 