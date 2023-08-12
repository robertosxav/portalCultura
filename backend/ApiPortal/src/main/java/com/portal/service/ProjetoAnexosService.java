package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoAnexos;
import com.portal.repository.ProjetoAnexosRepository;

@Service
public class ProjetoAnexosService {

	@Autowired
	private ProjetoAnexosRepository projetoanexosRepository;

	public ProjetoAnexos salvar(ProjetoAnexos projetoanexos) {
		return projetoanexosRepository.save(projetoanexos);
	}

	public ProjetoAnexos buscarPeloCodigo(Long codigo) {
		ProjetoAnexos projetoanexosSalva = projetoanexosRepository.findById(codigo).get();
		if (projetoanexosSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoanexosSalva;
	}

	public ProjetoAnexos atualizar(Long codigo, ProjetoAnexos projetoanexos) {
		ProjetoAnexos projetoanexosSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoanexos, projetoanexosSave, "projetoAnexosId");
		return projetoanexosRepository.save(projetoanexosSave);
	}

	public Page<ProjetoAnexos> pesquisar(Pageable pageable){
		return projetoanexosRepository.findAll(pageable);
	}

	public List<ProjetoAnexos> listarTodos() {
		return projetoanexosRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoanexosRepository.deleteById(codigo);
	}

}