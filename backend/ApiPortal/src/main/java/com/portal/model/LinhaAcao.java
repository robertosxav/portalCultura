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
@Table(name = "public.linha_acao") 
public class LinhaAcao implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "linha_acao_id")
	private Long linhaAcaoId;

	@Column(name = "linha_acao_nome")
	private String linhaAcaoNome;

	@Column(name = "linha_acao_ativo")
	private Integer linhaAcaoAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "linha_acao_inc_em")
	private Date linhaAcaoIncEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "linha_acao_alt_em")
	private Date linhaAcaoAltEm;

	@Column(name = "acao_categoria_id")
	private Integer acaoCategoriaId;

	public Long getLinhaAcaoId() {
		return linhaAcaoId;
	}
	 
	public void setLinhaAcaoId(Long linhaAcaoId) {
		this.linhaAcaoId = linhaAcaoId;
	}
	 
	public String getLinhaAcaoNome() {
		return linhaAcaoNome;
	}
	 
	public void setLinhaAcaoNome(String linhaAcaoNome) {
		this.linhaAcaoNome = linhaAcaoNome;
	}
	 
	public Integer getLinhaAcaoAtivo() {
		return linhaAcaoAtivo;
	}
	 
	public void setLinhaAcaoAtivo(Integer linhaAcaoAtivo) {
		this.linhaAcaoAtivo = linhaAcaoAtivo;
	}
	 
	public Date getLinhaAcaoIncEm() {
		return linhaAcaoIncEm;
	}
	 
	public void setLinhaAcaoIncEm(Date linhaAcaoIncEm) {
		this.linhaAcaoIncEm = linhaAcaoIncEm;
	}
	 
	public Date getLinhaAcaoAltEm() {
		return linhaAcaoAltEm;
	}
	 
	public void setLinhaAcaoAltEm(Date linhaAcaoAltEm) {
		this.linhaAcaoAltEm = linhaAcaoAltEm;
	}
	 
	public Integer getAcaoCategoriaId() {
		return acaoCategoriaId;
	}
	 
	public void setAcaoCategoriaId(Integer acaoCategoriaId) {
		this.acaoCategoriaId = acaoCategoriaId;
	}
	 

} 
