package com.portal.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.portal.exceptions.PortalException;
import com.portal.model.MacroRegiao;
import com.portal.model.MicroRegiao;
import com.portal.repository.MicroRegiaoRepository;

@Service
public class MicroRegiaoService {

	@Autowired
	private MicroRegiaoRepository microRegiaoRepository;
	
	@Autowired
	private MacroRegiaoService macroRegiaoService;

	public MicroRegiao salvar(MicroRegiao microRegiao) {
		validar(microRegiao);
		microRegiao.ativar();
		return microRegiaoRepository.save(microRegiao);
	}

	public MicroRegiao atualizar(Long codigo, MicroRegiao microRegiao) {
		MicroRegiao microRegiaoSalva = buscarPeloCodigo(codigo);
		BeanUtils.copyProperties(microRegiao, microRegiaoSalva, "id","status");
		return microRegiaoRepository.save(microRegiaoSalva);
	}
	
	public MicroRegiao buscarPeloCodigo(Long codigo) {
		MicroRegiao microRegiaoSalva = microRegiaoRepository
				.findById(codigo)
				.orElseThrow(()-> new PortalException("Id não encontrado"));
		return microRegiaoSalva;
	}

	public Page<MicroRegiao> pesquisar(Pageable pageable){
		return microRegiaoRepository.findAll(pageable);
	}

	public List<MicroRegiao> listarTodos() {
		return microRegiaoRepository.findAll();
	}

	public void remover(Long codigo) {
		MicroRegiao microRegiaoSalva = buscarPeloCodigo(codigo);
		microRegiaoSalva.inativar();
		microRegiaoRepository.save(microRegiaoSalva);
	}
	
	private void validar(MicroRegiao microRegiao) {
		MacroRegiao macroRegiao = macroRegiaoService.buscarPeloCodigo(microRegiao.getMacroRegiao().getId());
		microRegiao.setMacroRegiao(macroRegiao);
	}

	public List<MicroRegiao> listarMicroRegiaoPorMacroRegiao(Long idMacroRegiao) {
		return microRegiaoRepository.listarMicroRegiaoPorMacroRegiao(idMacroRegiao);
		
	}

}