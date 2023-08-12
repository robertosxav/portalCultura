package com.aut.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aut.model.Role;
import com.aut.model.User;


@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	  Optional<User> findByNomeRole(String nomeRole);
}
