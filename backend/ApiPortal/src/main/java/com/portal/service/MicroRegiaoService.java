package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.MicroRegiao;
import com.portal.repository.MicroRegiaoRepository;

@Service
public class MicroRegiaoService {

	@Autowired
	private MicroRegiaoRepository microregiaoRepository;

	public MicroRegiao salvar(MicroRegiao microregiao) {
		return microregiaoRepository.save(microregiao);
	}

	public MicroRegiao buscarPeloCodigo(Long codigo) {
		MicroRegiao microregiaoSalva = microregiaoRepository.findById(codigo).get();
		if (microregiaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return microregiaoSalva;
	}

	public MicroRegiao atualizar(Long codigo, MicroRegiao microregiao) {
		MicroRegiao microregiaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(microregiao, microregiaoSave, "microRegiaoId");
		return microregiaoRepository.save(microregiaoSave);
	}

	public Page<MicroRegiao> pesquisar(Pageable pageable){
		return microregiaoRepository.findAll(pageable);
	}

	public List<MicroRegiao> listarTodos() {
		return microregiaoRepository.findAll();
	}

	public void remover(Long codigo) {
		microregiaoRepository.deleteById(codigo);
	}

}