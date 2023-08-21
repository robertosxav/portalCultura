package com.aut.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aut.model.User;
import com.aut.repository.UserRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {
	
	@Autowired
	UserRepository useRepository;
	
	@GetMapping("/logado")	
	public ResponseEntity<User> buscarUsuarioLogado(){
		return ResponseEntity.ok(useRepository.findByUsername("05921855162").get());
		
	}
	
}
