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
@Table(name = "public.tipo_documento") 
public class TipoDocumento implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tipo_documento_id")
	private Long tipoDocumentoId;

	@Column(name = "tipo_documento_nome")
	private String tipoDocumentoNome;

	@Column(name = "tipo_documento_ativo")
	private Integer tipoDocumentoAtivo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tipo_documento_inc_em")
	private Date tipoDocumentoIncEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "tipo_documento_alt_em")
	private Date tipoDocumentoAltEm;

	public Long getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	 
	public void setTipoDocumentoId(Long tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	 
	public String getTipoDocumentoNome() {
		return tipoDocumentoNome;
	}
	 
	public void setTipoDocumentoNome(String tipoDocumentoNome) {
		this.tipoDocumentoNome = tipoDocumentoNome;
	}
	 
	public Integer getTipoDocumentoAtivo() {
		return tipoDocumentoAtivo;
	}
	 
	public void setTipoDocumentoAtivo(Integer tipoDocumentoAtivo) {
		this.tipoDocumentoAtivo = tipoDocumentoAtivo;
	}
	 
	public Date getTipoDocumentoIncEm() {
		return tipoDocumentoIncEm;
	}
	 
	public void setTipoDocumentoIncEm(Date tipoDocumentoIncEm) {
		this.tipoDocumentoIncEm = tipoDocumentoIncEm;
	}
	 
	public Date getTipoDocumentoAltEm() {
		return tipoDocumentoAltEm;
	}
	 
	public void setTipoDocumentoAltEm(Date tipoDocumentoAltEm) {
		this.tipoDocumentoAltEm = tipoDocumentoAltEm;
	}
	 

} 
