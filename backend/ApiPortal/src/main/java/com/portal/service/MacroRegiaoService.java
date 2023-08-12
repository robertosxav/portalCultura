package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.model.MacroRegiao;
import com.portal.repository.MacroRegiaoRepository;

@Service
public class MacroRegiaoService {

	@Autowired
	private MacroRegiaoRepository macroregiaoRepository;

	public MacroRegiao salvar(MacroRegiao macroregiao) {
		return macroregiaoRepository.save(macroregiao);
	}

	public MacroRegiao buscarPeloCodigo(Long codigo) {
		MacroRegiao macroregiaoSalva = macroregiaoRepository.findById(codigo).get();
		if (macroregiaoSalva == null) {
		throw new EmptyResultDataAccessException(1);
			}
		return macroregiaoSalva;
	}

	public MacroRegiao atualizar(Long codigo, MacroRegiao macroregiao) {
		MacroRegiao macroregiaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(macroregiao, macroregiaoSave, "macroRegiaoId");
		return macroregiaoRepository.save(macroregiaoSave);
	}

	public Page<MacroRegiao> pesquisar(Pageable pageable){
		return macroregiaoRepository.findAll(pageable);
	}

	public List<MacroRegiao> listarTodos() {
		return macroregiaoRepository.findAll();
	}

	public void remover(Long codigo) {
		macroregiaoRepository.deleteById(codigo);
	}

}