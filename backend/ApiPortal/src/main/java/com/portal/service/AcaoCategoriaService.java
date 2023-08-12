package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.AcaoCategoria;
import com.portal.repository.AcaoCategoriaRepository;

@Service
public class AcaoCategoriaService {

	@Autowired
	private AcaoCategoriaRepository acaocategoriaRepository;

	public AcaoCategoria salvar(AcaoCategoria acaocategoria) {
		return acaocategoriaRepository.save(acaocategoria);
	}

	public AcaoCategoria buscarPeloCodigo(Long codigo) {
		AcaoCategoria acaocategoriaSalva = acaocategoriaRepository.findById(codigo).get();
		if (acaocategoriaSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return acaocategoriaSalva;
	}

	public AcaoCategoria atualizar(Long codigo, AcaoCategoria acaocategoria) {
		AcaoCategoria acaocategoriaSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(acaocategoria, acaocategoriaSave, "acaoCategoriaId");
		return acaocategoriaRepository.save(acaocategoriaSave);
	}

	public Page<AcaoCategoria> pesquisar(Pageable pageable){
		return acaocategoriaRepository.findAll(pageable);
	}

	public List<AcaoCategoria> listarTodos() {
		return acaocategoriaRepository.findAll();
	}

	public void remover(Long codigo) {
		acaocategoriaRepository.deleteById(codigo);
	}

}