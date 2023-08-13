package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "macro_regiao",schema="public") 
public class MacroRegiao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "macro_regiao_id")
	private Long macroRegiaoId;

	@Column(name = "macro_regiao_nome")
	private String macroRegiaoNome;

	@Column(name = "macro_regiao_ativo")
	private Integer macroRegiaoAtivo;

	public Long getMacroRegiaoId() {
		return macroRegiaoId;
	}
	 
	public void setMacroRegiaoId(Long macroRegiaoId) {
		this.macroRegiaoId = macroRegiaoId;
	}
	 
	public String getMacroRegiaoNome() {
		return macroRegiaoNome;
	}
	 
	public void setMacroRegiaoNome(String macroRegiaoNome) {
		this.macroRegiaoNome = macroRegiaoNome;
	}
	 
	public Integer getMacroRegiaoAtivo() {
		return macroRegiaoAtivo;
	}
	 
	public void setMacroRegiaoAtivo(Integer macroRegiaoAtivo) {
		this.macroRegiaoAtivo = macroRegiaoAtivo;
	}
	 

} 
