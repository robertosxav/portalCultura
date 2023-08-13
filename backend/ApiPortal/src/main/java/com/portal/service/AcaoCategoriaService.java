package com.portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.AcaoCategoria;
import com.portal.repository.AcaoCategoriaRepository;

@Service
public class AcaoCategoriaService {

	@Autowired
	private AcaoCategoriaRepository acaoCategoriaRepository;

	public AcaoCategoria salvar(AcaoCategoria acaoCategoria) {
		acaoCategoria.ativar();
		return acaoCategoriaRepository.save(acaoCategoria);
	}

	public AcaoCategoria atualizar(Long codigo, AcaoCategoria acaoCategoria) {
		AcaoCategoria acaoCategoriaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(acaoCategoria, acaoCategoriaSave, "acaoCategoriaId","status");
		acaoCategoriaSave.setAlteradoEm(LocalDate.now());
		return acaoCategoriaRepository.save(acaoCategoriaSave);
	}

	public AcaoCategoria buscarPeloCodigo(Long codigo) {
		AcaoCategoria acaoCategoriaSalva = acaoCategoriaRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		
		return acaoCategoriaSalva;
	}
	
	public Page<AcaoCategoria> pesquisar(Pageable pageable){
		return acaoCategoriaRepository.findAll(pageable);
	}

	public List<AcaoCategoria> listarTodos() {
		return acaoCategoriaRepository.findAll();
	}

	public void remover(Long codigo) {
		AcaoCategoria acaoCategoriaSave = buscarPeloCodigo(codigo);
		acaoCategoriaSave.inativar();
		acaoCategoriaRepository.save(acaoCategoriaSave);
	}

}