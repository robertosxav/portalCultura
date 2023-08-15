package com.portal.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portal.model.User;
import com.portal.service.UsuarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "Usuários")
@RestController
@RequestMapping("/usuarios")
public class UsuarioResource {

	@Autowired
	UsuarioService usuarioService;
	
	@Operation(description = "Serviço para criar um usuário")
	@PostMapping
	public ResponseEntity<User> criarUsuario(@Validated @RequestBody User usuario) {
		User usuarioSalvo = usuarioService.criarUsuario(usuario);
		return ResponseEntity.status(HttpStatus.CREATED).body(usuarioSalvo);
	}
}