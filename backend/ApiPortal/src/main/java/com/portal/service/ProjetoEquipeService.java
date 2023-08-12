package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoEquipe;
import com.portal.repository.ProjetoEquipeRepository;

@Service
public class ProjetoEquipeService {

	@Autowired
	private ProjetoEquipeRepository projetoequipeRepository;

	public ProjetoEquipe salvar(ProjetoEquipe projetoequipe) {
		return projetoequipeRepository.save(projetoequipe);
	}

	public ProjetoEquipe buscarPeloCodigo(Long codigo) {
		ProjetoEquipe projetoequipeSalva = projetoequipeRepository.findById(codigo).get();
		if (projetoequipeSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoequipeSalva;
	}

	public ProjetoEquipe atualizar(Long codigo, ProjetoEquipe projetoequipe) {
		ProjetoEquipe projetoequipeSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoequipe, projetoequipeSave, "projetoEquipeId");
		return projetoequipeRepository.save(projetoequipeSave);
	}

	public Page<ProjetoEquipe> pesquisar(Pageable pageable){
		return projetoequipeRepository.findAll(pageable);
	}

	public List<ProjetoEquipe> listarTodos() {
		return projetoequipeRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoequipeRepository.deleteById(codigo);
	}

}