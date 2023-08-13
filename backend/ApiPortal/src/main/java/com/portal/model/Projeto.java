package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto",schema="public") 
public class Projeto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_id")
	private Long projetoId;

	@Column(name = "pessoa_id")
	private String pessoaId;

	@Column(name = "projeto_nome")
	private Integer projetoNome;

	@Column(name = "projeto_status")
	private Integer projetoStatus;

	@Column(name = "producao_id")
	private Integer producaoId;

	@Column(name = "area_cultural_id")
	private Integer areaCulturalId;

	@Column(name = "edital_id")
	private String editalId;

	public Long getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(Long projetoId) {
		this.projetoId = projetoId;
	}
	 
	public String getPessoaId() {
		return pessoaId;
	}
	 
	public void setPessoaId(String pessoaId) {
		this.pessoaId = pessoaId;
	}
	 
	public Integer getProjetoNome() {
		return projetoNome;
	}
	 
	public void setProjetoNome(Integer projetoNome) {
		this.projetoNome = projetoNome;
	}
	 
	public Integer getProjetoStatus() {
		return projetoStatus;
	}
	 
	public void setProjetoStatus(Integer projetoStatus) {
		this.projetoStatus = projetoStatus;
	}
	 
	public Integer getProducaoId() {
		return producaoId;
	}
	 
	public void setProducaoId(Integer producaoId) {
		this.producaoId = producaoId;
	}
	 
	public Integer getAreaCulturalId() {
		return areaCulturalId;
	}
	 
	public void setAreaCulturalId(Integer areaCulturalId) {
		this.areaCulturalId = areaCulturalId;
	}
	 
	public String getEditalId() {
		return editalId;
	}
	 
	public void setEditalId(String editalId) {
		this.editalId = editalId;
	}
	 

} 
