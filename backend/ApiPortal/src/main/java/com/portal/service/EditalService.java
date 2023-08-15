package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.Edital;
import com.portal.repository.EditalRepository;

@Service
public class EditalService {

	@Autowired
	private EditalRepository editalRepository;

	public Edital salvar(Edital edital) {
		validar(edital);
		edital.iniciar();
		return editalRepository.save(edital);
	}

	public Edital atualizar(Long codigo, Edital edital) {
		Edital editalSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(edital, editalSave, "id","statusEdital");
		return editalRepository.save(editalSave);
	}
	
	public Edital buscarPeloCodigo(Long codigo) {
		Edital editalSalva = editalRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return editalSalva;
	}


	public Page<Edital> pesquisar(Pageable pageable){
		return editalRepository.findAll(pageable);
	}

	public List<Edital> listarTodos() {
		return editalRepository.findAll();
	}

	/*public void remover(Long codigo) {
		Edital editalSave = buscarPeloCodigo(codigo);
		editalRepository.save(editalSave);
	}
	*/
	
	private void validar(Edital edital) {
		//validação das datas		
	}
}