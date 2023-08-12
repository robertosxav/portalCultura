package com.portal.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "public.acao_categoria") 
public class AcaoCategoria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acao_categoria_id")
	private Long acaoCategoriaId;

	@Column(name = "acao_categoria_nome")
	private String acaoCategoriaNome;

	@Column(name = "acao_categoria_ativo")
	private Integer acaoCategoriaAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acao_categoria_inc_em")
	private Date acaoCategoriaIncEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acao_categoria_alt_em")
	private Date acaoCategoriaAltEm;

	public Long getAcaoCategoriaId() {
		return acaoCategoriaId;
	}
	 
	public void setAcaoCategoriaId(Long acaoCategoriaId) {
		this.acaoCategoriaId = acaoCategoriaId;
	}
	 
	public String getAcaoCategoriaNome() {
		return acaoCategoriaNome;
	}
	 
	public void setAcaoCategoriaNome(String acaoCategoriaNome) {
		this.acaoCategoriaNome = acaoCategoriaNome;
	}
	 
	public Integer getAcaoCategoriaAtivo() {
		return acaoCategoriaAtivo;
	}
	 
	public void setAcaoCategoriaAtivo(Integer acaoCategoriaAtivo) {
		this.acaoCategoriaAtivo = acaoCategoriaAtivo;
	}
	 
	public Date getAcaoCategoriaIncEm() {
		return acaoCategoriaIncEm;
	}
	 
	public void setAcaoCategoriaIncEm(Date acaoCategoriaIncEm) {
		this.acaoCategoriaIncEm = acaoCategoriaIncEm;
	}
	 
	public Date getAcaoCategoriaAltEm() {
		return acaoCategoriaAltEm;
	}
	 
	public void setAcaoCategoriaAltEm(Date acaoCategoriaAltEm) {
		this.acaoCategoriaAltEm = acaoCategoriaAltEm;
	}
	 

} 
