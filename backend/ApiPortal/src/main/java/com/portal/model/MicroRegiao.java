package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "micro_regiao",schema="public") 
public class MicroRegiao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "micro_regiao_id")
	private Long microRegiaoId;

	@Column(name = "micro_regiao_nome")
	private String microRegiaoNome;

	@Column(name = "micro_regiao_ativo")
	private Integer microRegiaoAtivo;

	@Column(name = "macro_regiao_id")
	private String macroRegiaoId;

	public Long getMicroRegiaoId() {
		return microRegiaoId;
	}
	 
	public void setMicroRegiaoId(Long microRegiaoId) {
		this.microRegiaoId = microRegiaoId;
	}
	 
	public String getMicroRegiaoNome() {
		return microRegiaoNome;
	}
	 
	public void setMicroRegiaoNome(String microRegiaoNome) {
		this.microRegiaoNome = microRegiaoNome;
	}
	 
	public Integer getMicroRegiaoAtivo() {
		return microRegiaoAtivo;
	}
	 
	public void setMicroRegiaoAtivo(Integer microRegiaoAtivo) {
		this.microRegiaoAtivo = microRegiaoAtivo;
	}
	 
	public String getMacroRegiaoId() {
		return macroRegiaoId;
	}
	 
	public void setMacroRegiaoId(String macroRegiaoId) {
		this.macroRegiaoId = macroRegiaoId;
	}
	 

} 
