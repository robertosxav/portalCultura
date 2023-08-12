package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.AreaCultural;
import com.portal.repository.AreaCulturalRepository;

@Service
public class AreaCulturalService {

	@Autowired
	private AreaCulturalRepository areaculturalRepository;

	public AreaCultural salvar(AreaCultural areacultural) {
		return areaculturalRepository.save(areacultural);
	}

	public AreaCultural buscarPeloCodigo(Long codigo) {
		AreaCultural areaculturalSalva = areaculturalRepository.findById(codigo).get();
		if (areaculturalSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return areaculturalSalva;
	}

	public AreaCultural atualizar(Long codigo, AreaCultural areacultural) {
		AreaCultural areaculturalSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(areacultural, areaculturalSave, "areaCulturalId");
		return areaculturalRepository.save(areaculturalSave);
	}

	public Page<AreaCultural> pesquisar(Pageable pageable){
		return areaculturalRepository.findAll(pageable);
	}

	public List<AreaCultural> listarTodos() {
		return areaculturalRepository.findAll();
	}

	public void remover(Long codigo) {
		areaculturalRepository.deleteById(codigo);
	}

}