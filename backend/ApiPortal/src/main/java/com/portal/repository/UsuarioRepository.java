package com.portal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.portal.model.User;

@Repository
public interface UsuarioRepository extends JpaRepository<User, Long>{ 
}