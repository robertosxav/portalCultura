package com.portal.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "public.producao") 
public class Producao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "producao_id")
	private Long producaoId;

	@Column(name = "producao_nome")
	private String producaoNome;

	@Column(name = "producao_ativo")
	private Integer producaoAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "producao_inc_em")
	private Date producaoIncEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "producao_upd_em")
	private Date producaoUpdEm;

	public Long getProducaoId() {
		return producaoId;
	}
	 
	public void setProducaoId(Long producaoId) {
		this.producaoId = producaoId;
	}
	 
	public String getProducaoNome() {
		return producaoNome;
	}
	 
	public void setProducaoNome(String producaoNome) {
		this.producaoNome = producaoNome;
	}
	 
	public Integer getProducaoAtivo() {
		return producaoAtivo;
	}
	 
	public void setProducaoAtivo(Integer producaoAtivo) {
		this.producaoAtivo = producaoAtivo;
	}
	 
	public Date getProducaoIncEm() {
		return producaoIncEm;
	}
	 
	public void setProducaoIncEm(Date producaoIncEm) {
		this.producaoIncEm = producaoIncEm;
	}
	 
	public Date getProducaoUpdEm() {
		return producaoUpdEm;
	}
	 
	public void setProducaoUpdEm(Date producaoUpdEm) {
		this.producaoUpdEm = producaoUpdEm;
	}
	 

} 
