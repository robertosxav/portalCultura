package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoCoordenador;
import com.portal.repository.ProjetoCoordenadorRepository;

@Service
public class ProjetoCoordenadorService {

	@Autowired
	private ProjetoCoordenadorRepository projetocoordenadorRepository;

	public ProjetoCoordenador salvar(ProjetoCoordenador projetocoordenador) {
		return projetocoordenadorRepository.save(projetocoordenador);
	}

	public ProjetoCoordenador buscarPeloCodigo(Long codigo) {
		ProjetoCoordenador projetocoordenadorSalva = projetocoordenadorRepository.findById(codigo).get();
		if (projetocoordenadorSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetocoordenadorSalva;
	}

	public ProjetoCoordenador atualizar(Long codigo, ProjetoCoordenador projetocoordenador) {
		ProjetoCoordenador projetocoordenadorSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetocoordenador, projetocoordenadorSave, "projetoCoordenadorId");
		return projetocoordenadorRepository.save(projetocoordenadorSave);
	}

	public Page<ProjetoCoordenador> pesquisar(Pageable pageable){
		return projetocoordenadorRepository.findAll(pageable);
	}

	public List<ProjetoCoordenador> listarTodos() {
		return projetocoordenadorRepository.findAll();
	}

	public void remover(Long codigo) {
		projetocoordenadorRepository.deleteById(codigo);
	}

}