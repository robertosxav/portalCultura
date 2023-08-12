package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.projeto_abrangencia") 
public class ProjetoAbrangencia implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_abrangencia_id")
	private Long projetoAbrangenciaId;

	@Column(name = "projeto_id")
	private String projetoId;

	@Column(name = "micro_regiao_id")
	private String microRegiaoId;

	public Long getProjetoAbrangenciaId() {
		return projetoAbrangenciaId;
	}
	 
	public void setProjetoAbrangenciaId(Long projetoAbrangenciaId) {
		this.projetoAbrangenciaId = projetoAbrangenciaId;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 
	public String getMicroRegiaoId() {
		return microRegiaoId;
	}
	 
	public void setMicroRegiaoId(String microRegiaoId) {
		this.microRegiaoId = microRegiaoId;
	}
	 

} 
