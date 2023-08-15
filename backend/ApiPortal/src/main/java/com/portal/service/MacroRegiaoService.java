package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.MacroRegiao;
import com.portal.repository.MacroRegiaoRepository;

@Service
public class MacroRegiaoService {

	@Autowired
	private MacroRegiaoRepository macroRegiaoRepository;

	public MacroRegiao salvar(MacroRegiao macroRegiao) {
		macroRegiao.ativar();
		return macroRegiaoRepository.save(macroRegiao);
	}

	public MacroRegiao atualizar(Long codigo, MacroRegiao macroRegiao) {
		MacroRegiao macroRegiaoSave = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(macroRegiao, macroRegiaoSave, "id","status");
		return macroRegiaoRepository.save(macroRegiaoSave);
	}
	
	public MacroRegiao buscarPeloCodigo(Long codigo) {
		MacroRegiao macroRegiaoSalva = macroRegiaoRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return macroRegiaoSalva;
	}

	public Page<MacroRegiao> pesquisar(Pageable pageable){
		return macroRegiaoRepository.findAll(pageable);
	}

	public List<MacroRegiao> listarTodos() {
		return macroRegiaoRepository.findAll();
	}

	public void remover(Long codigo) {
		MacroRegiao macroRegiaoSave = buscarPeloCodigo(codigo);
		macroRegiaoSave.inativar();
		macroRegiaoRepository.save(macroRegiaoSave);
	}
}