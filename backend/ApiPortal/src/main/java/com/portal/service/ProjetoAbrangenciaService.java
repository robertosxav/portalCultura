package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoAbrangencia;
import com.portal.repository.ProjetoAbrangenciaRepository;

@Service
public class ProjetoAbrangenciaService {

	@Autowired
	private ProjetoAbrangenciaRepository projetoabrangenciaRepository;

	public ProjetoAbrangencia salvar(ProjetoAbrangencia projetoabrangencia) {
		return projetoabrangenciaRepository.save(projetoabrangencia);
	}

	public ProjetoAbrangencia buscarPeloCodigo(Long codigo) {
		ProjetoAbrangencia projetoabrangenciaSalva = projetoabrangenciaRepository.findById(codigo).get();
		if (projetoabrangenciaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetoabrangenciaSalva;
	}

	public ProjetoAbrangencia atualizar(Long codigo, ProjetoAbrangencia projetoabrangencia) {
		ProjetoAbrangencia projetoabrangenciaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetoabrangencia, projetoabrangenciaSave, "projetoAbrangenciaId");
		return projetoabrangenciaRepository.save(projetoabrangenciaSave);
	}

	public Page<ProjetoAbrangencia> pesquisar(Pageable pageable){
		return projetoabrangenciaRepository.findAll(pageable);
	}

	public List<ProjetoAbrangencia> listarTodos() {
		return projetoabrangenciaRepository.findAll();
	}

	public void remover(Long codigo) {
		projetoabrangenciaRepository.deleteById(codigo);
	}

}