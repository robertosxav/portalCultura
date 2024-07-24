package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.LeiTemplate;

@Repository
public interface LeiTemplateRepository extends JpaRepository<LeiTemplate, Long>{ 
	
} 