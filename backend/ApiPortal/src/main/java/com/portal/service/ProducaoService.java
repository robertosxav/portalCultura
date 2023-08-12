package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.Producao;
import com.portal.repository.ProducaoRepository;

@Service
public class ProducaoService {

	@Autowired
	private ProducaoRepository producaoRepository;

	public Producao salvar(Producao producao) {
		return producaoRepository.save(producao);
	}

	public Producao buscarPeloCodigo(Long codigo) {
		Producao producaoSalva = producaoRepository.findById(codigo).get();
		if (producaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return producaoSalva;
	}

	public Producao atualizar(Long codigo, Producao producao) {
		Producao producaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(producao, producaoSave, "producaoId");
		return producaoRepository.save(producaoSave);
	}

	public Page<Producao> pesquisar(Pageable pageable){
		return producaoRepository.findAll(pageable);
	}

	public List<Producao> listarTodos() {
		return producaoRepository.findAll();
	}

	public void remover(Long codigo) {
		producaoRepository.deleteById(codigo);
	}

}