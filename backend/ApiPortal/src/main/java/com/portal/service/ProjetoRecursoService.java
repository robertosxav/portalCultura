package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoRecurso;
import com.portal.repository.ProjetoRecursoRepository;

@Service
public class ProjetoRecursoService {

	@Autowired
	private ProjetoRecursoRepository projetorecursoRepository;

	public ProjetoRecurso salvar(ProjetoRecurso projetorecurso) {
		return projetorecursoRepository.save(projetorecurso);
	}

	public ProjetoRecurso buscarPeloCodigo(Long codigo) {
		ProjetoRecurso projetorecursoSalva = projetorecursoRepository.findById(codigo).get();
		if (projetorecursoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetorecursoSalva;
	}

	public ProjetoRecurso atualizar(Long codigo, ProjetoRecurso projetorecurso) {
		ProjetoRecurso projetorecursoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetorecurso, projetorecursoSave, "projetoRecursoId");
		return projetorecursoRepository.save(projetorecursoSave);
	}

	public Page<ProjetoRecurso> pesquisar(Pageable pageable){
		return projetorecursoRepository.findAll(pageable);
	}

	public List<ProjetoRecurso> listarTodos() {
		return projetorecursoRepository.findAll();
	}

	public void remover(Long codigo) {
		projetorecursoRepository.deleteById(codigo);
	}

}