package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.ProjetoLinhaAcao;
import com.portal.repository.ProjetoLinhaAcaoRepository;

@Service
public class ProjetoLinhaAcaoService {

	@Autowired
	private ProjetoLinhaAcaoRepository projetolinhaacaoRepository;

	public ProjetoLinhaAcao salvar(ProjetoLinhaAcao projetolinhaacao) {
		return projetolinhaacaoRepository.save(projetolinhaacao);
	}

	public ProjetoLinhaAcao buscarPeloCodigo(Long codigo) {
		ProjetoLinhaAcao projetolinhaacaoSalva = projetolinhaacaoRepository.findById(codigo).get();
		if (projetolinhaacaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return projetolinhaacaoSalva;
	}

	public ProjetoLinhaAcao atualizar(Long codigo, ProjetoLinhaAcao projetolinhaacao) {
		ProjetoLinhaAcao projetolinhaacaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(projetolinhaacao, projetolinhaacaoSave, "projetoLinhaAcaoId");
		return projetolinhaacaoRepository.save(projetolinhaacaoSave);
	}

	public Page<ProjetoLinhaAcao> pesquisar(Pageable pageable){
		return projetolinhaacaoRepository.findAll(pageable);
	}

	public List<ProjetoLinhaAcao> listarTodos() {
		return projetolinhaacaoRepository.findAll();
	}

	public void remover(Long codigo) {
		projetolinhaacaoRepository.deleteById(codigo);
	}

}