package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoDados;
import com.portal.repository.ProjetoDadosRepository;

@Service
public class ProjetoDadosService {

	@Autowired
	private ProjetoDadosRepository projetodadosRepository;

	public ProjetoDados salvar(ProjetoDados projetodados) {
		return projetodadosRepository.save(projetodados);
	}

	public ProjetoDados buscarPeloCodigo(Long codigo) {
		ProjetoDados projetodadosSalva = projetodadosRepository.findById(codigo).get();
		if (projetodadosSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetodadosSalva;
	}

	public ProjetoDados atualizar(Long codigo, ProjetoDados projetodados) {
		ProjetoDados projetodadosSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetodados, projetodadosSave, "projetoDadosId");
		return projetodadosRepository.save(projetodadosSave);
	}

	public Page<ProjetoDados> pesquisar(Pageable pageable){
		return projetodadosRepository.findAll(pageable);
	}

	public List<ProjetoDados> listarTodos() {
		return projetodadosRepository.findAll();
	}

	public void remover(Long codigo) {
		projetodadosRepository.deleteById(codigo);
	}

}