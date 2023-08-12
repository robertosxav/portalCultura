package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.LinhaAcao;
import com.portal.repository.LinhaAcaoRepository;

@Service
public class LinhaAcaoService {

	@Autowired
	private LinhaAcaoRepository linhaacaoRepository;

	public LinhaAcao salvar(LinhaAcao linhaacao) {
		return linhaacaoRepository.save(linhaacao);
	}

	public LinhaAcao buscarPeloCodigo(Long codigo) {
		LinhaAcao linhaacaoSalva = linhaacaoRepository.findById(codigo).get();
		if (linhaacaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return linhaacaoSalva;
	}

	public LinhaAcao atualizar(Long codigo, LinhaAcao linhaacao) {
		LinhaAcao linhaacaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(linhaacao, linhaacaoSave, "linhaAcaoId");
		return linhaacaoRepository.save(linhaacaoSave);
	}

	public Page<LinhaAcao> pesquisar(Pageable pageable){
		return linhaacaoRepository.findAll(pageable);
	}

	public List<LinhaAcao> listarTodos() {
		return linhaacaoRepository.findAll();
	}

	public void remover(Long codigo) {
		linhaacaoRepository.deleteById(codigo);
	}

}