package com.aut.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.aut.model.User;


@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	 // Optional<User> findByEmail(String email);
	 // Optional<User> findByUsernameOrEmail(String username, String email);
	  User findByUsername(String username);
	 // Boolean existsByUsername(String username);
	 // Boolean existsByEmail(String email);
}
