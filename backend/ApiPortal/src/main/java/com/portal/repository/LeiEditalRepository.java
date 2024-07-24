package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.LeiEdital;

@Repository
public interface LeiEditalRepository extends JpaRepository<LeiEdital, Long>{ 
	
} 