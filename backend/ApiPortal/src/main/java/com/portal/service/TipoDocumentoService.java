package com.portal.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.TipoDocumento;
import com.portal.repository.TipoDocumentoRepository;

@Service
public class TipoDocumentoService {

	@Autowired
	private TipoDocumentoRepository tipoDocumentoRepository;

	public TipoDocumento salvar(TipoDocumento tipoDocumento) {
		tipoDocumento.ativar();
		return tipoDocumentoRepository.save(tipoDocumento);
	}

	public TipoDocumento atualizar(Long codigo, TipoDocumento tipoDocumento) {
		TipoDocumento tipoDocumentoSalva = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(tipoDocumento, tipoDocumentoSalva, "id","status","incluidoEm");
		tipoDocumentoSalva.setAlteradoEm(LocalDate.now());
		return tipoDocumentoRepository.save(tipoDocumentoSalva);
	}
	
	public TipoDocumento buscarPeloCodigo(Long codigo) {
		TipoDocumento tipoDocumentoSalva = tipoDocumentoRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return tipoDocumentoSalva;
	}

	public Page<TipoDocumento> pesquisar(Pageable pageable){
		return tipoDocumentoRepository.findAll(pageable);
	}

	public List<TipoDocumento> listarTodos() {
		return tipoDocumentoRepository.findAll();
	}

	public void remover(Long codigo) {
		TipoDocumento tipoDocumentoSalva = buscarPeloCodigo(codigo);
		tipoDocumentoSalva.inativar();
		tipoDocumentoRepository.save(tipoDocumentoSalva);
	}

}