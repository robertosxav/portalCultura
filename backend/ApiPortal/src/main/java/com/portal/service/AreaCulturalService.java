package com.portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.AreaCultural;
import com.portal.repository.AreaCulturalRepository;

@Service
public class AreaCulturalService {

	@Autowired
	private AreaCulturalRepository areaCulturalRepository;

	public AreaCultural salvar(AreaCultural areaCultural) {
		areaCultural.ativar();
		return areaCulturalRepository.save(areaCultural);
	}

	public AreaCultural atualizar(Long codigo, AreaCultural areaCultural) {
		AreaCultural areaCulturalSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(areaCultural, areaCulturalSave, "id","status","incluidoEm");
		areaCulturalSave.setAlteradoEm(LocalDate.now());
		return areaCulturalRepository.save(areaCulturalSave);
	}
	
	public AreaCultural buscarPeloCodigo(Long codigo) {
		AreaCultural areaCulturalSalva = areaCulturalRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return areaCulturalSalva;
	}

	public Page<AreaCultural> pesquisar(Pageable pageable){
		return areaCulturalRepository.findAll(pageable);
	}

	public List<AreaCultural> listarTodos() {
		return areaCulturalRepository.findAll();
	}

	public void remover(Long codigo) {
		AreaCultural areaCulturalSave = buscarPeloCodigo(codigo);
		areaCulturalSave.inativar();
		areaCulturalRepository.save(areaCulturalSave);
	}

}