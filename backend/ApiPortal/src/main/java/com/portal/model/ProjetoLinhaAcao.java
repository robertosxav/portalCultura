package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto_linha_acao",schema="public") 
public class ProjetoLinhaAcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_linha_acao_id")
	private Long projetoLinhaAcaoId;

	@Column(name = "projeto_id")
	private String projetoId;

	@Column(name = "linha_acao_id")
	private String linhaAcaoId;

	public Long getProjetoLinhaAcaoId() {
		return projetoLinhaAcaoId;
	}
	 
	public void setProjetoLinhaAcaoId(Long projetoLinhaAcaoId) {
		this.projetoLinhaAcaoId = projetoLinhaAcaoId;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 
	public String getLinhaAcaoId() {
		return linhaAcaoId;
	}
	 
	public void setLinhaAcaoId(String linhaAcaoId) {
		this.linhaAcaoId = linhaAcaoId;
	}
	 

} 
