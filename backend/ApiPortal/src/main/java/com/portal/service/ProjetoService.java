package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.Projeto;
import com.portal.repository.ProjetoRepository;

@Service
public class ProjetoService {

	@Autowired
	private ProjetoRepository projetoRepository;

	public Projeto salvar(Projeto projeto) {
		return projetoRepository.save(projeto);
	}

	public Projeto buscarPeloCodigo(Long codigo) {
		Projeto projetoSalva = projetoRepository.findById(codigo).get();
		if (projetoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoSalva;
	}

	public Projeto atualizar(Long codigo, Projeto projeto) {
		Projeto projetoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projeto, projetoSave, "projetoId");
		return projetoRepository.save(projetoSave);
	}

	public Page<Projeto> pesquisar(Pageable pageable){
		return projetoRepository.findAll(pageable);
	}

	public List<Projeto> listarTodos() {
		return projetoRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoRepository.deleteById(codigo);
	}

}