package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoResponsavel;
import com.portal.repository.ProjetoResponsavelRepository;

@Service
public class ProjetoResponsavelService {

	@Autowired
	private ProjetoResponsavelRepository projetoresponsavelRepository;

	public ProjetoResponsavel salvar(ProjetoResponsavel projetoresponsavel) {
		return projetoresponsavelRepository.save(projetoresponsavel);
	}

	public ProjetoResponsavel buscarPeloCodigo(Long codigo) {
		ProjetoResponsavel projetoresponsavelSalva = projetoresponsavelRepository.findById(codigo).get();
		if (projetoresponsavelSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoresponsavelSalva;
	}

	public ProjetoResponsavel atualizar(Long codigo, ProjetoResponsavel projetoresponsavel) {
		ProjetoResponsavel projetoresponsavelSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoresponsavel, projetoresponsavelSave, "projetoResponsavelId");
		return projetoresponsavelRepository.save(projetoresponsavelSave);
	}

	public Page<ProjetoResponsavel> pesquisar(Pageable pageable){
		return projetoresponsavelRepository.findAll(pageable);
	}

	public List<ProjetoResponsavel> listarTodos() {
		return projetoresponsavelRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoresponsavelRepository.deleteById(codigo);
	}

}