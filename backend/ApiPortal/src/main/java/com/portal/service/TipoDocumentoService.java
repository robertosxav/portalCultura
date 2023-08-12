package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.TipoDocumento;
import com.portal.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipodocumentoRepository;

	public TipoDocumento salvar(TipoDocumento tipodocumento) {
		return tipodocumentoRepository.save(tipodocumento);
	}

	public TipoDocumento buscarPeloCodigo(Long codigo) {
		TipoDocumento tipodocumentoSalva = tipodocumentoRepository.findById(codigo).get();
		if (tipodocumentoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return tipodocumentoSalva;
	}

	public TipoDocumento atualizar(Long codigo, TipoDocumento tipodocumento) {
		TipoDocumento tipodocumentoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(tipodocumento, tipodocumentoSave, "tipoDocumentoId");
		return tipodocumentoRepository.save(tipodocumentoSave);
	}

	public Page<TipoDocumento> pesquisar(Pageable pageable){
		return tipodocumentoRepository.findAll(pageable);
	}

	public List<TipoDocumento> listarTodos() {
		return tipodocumentoRepository.findAll();
	}

	public void remover(Long codigo) {
		tipodocumentoRepository.deleteById(codigo);
	}

}