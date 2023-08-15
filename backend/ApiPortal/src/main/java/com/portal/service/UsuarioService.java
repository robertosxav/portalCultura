package com.portal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portal.model.User;
import com.portal.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	public User criarUsuario(User usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
}