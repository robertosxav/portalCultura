package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.Edital;
import com.portal.repository.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;

	public Edital salvar(Edital edital) {
		return editalRepository.save(edital);
	}

	public Edital buscarPeloCodigo(Long codigo) {
		Edital editalSalva = editalRepository.findById(codigo).get();
		if (editalSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return editalSalva;
	}

	public Edital atualizar(Long codigo, Edital edital) {
		Edital editalSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(edital, editalSave, "editalId");
		return editalRepository.save(editalSave);
	}

	public Page<Edital> pesquisar(Pageable pageable){
		return editalRepository.findAll(pageable);
	}

	public List<Edital> listarTodos() {
		return editalRepository.findAll();
	}

	public void remover(Long codigo) {
		editalRepository.deleteById(codigo);
	}

}