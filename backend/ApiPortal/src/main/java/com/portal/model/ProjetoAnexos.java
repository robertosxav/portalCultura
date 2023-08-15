package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto_anexos",schema="public") 
public class ProjetoAnexos implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "projeto_anexos_id")
	private Long projetoAnexosId;

	@Column(name = "tipo_documento_id")
	private String tipoDocumentoId;

	@Column(name = "projeto_anexos_venc")
	private String projetoAnexosVenc;

	@Column(name = "projeto_anexos_blob")
	private String projetoAnexosBlob;

	@Column(name = "projeto_anexos_blob_tipo")
	private String projetoAnexosBlobTipo;

	@Column(name = "projeto_anexos_blob_name")
	private String projetoAnexosBlobName;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoAnexosId() {
		return projetoAnexosId;
	}
	 
	public void setProjetoAnexosId(Long projetoAnexosId) {
		this.projetoAnexosId = projetoAnexosId;
	}
	 
	public String getTipoDocumentoId() {
		return tipoDocumentoId;
	}
	 
	public void setTipoDocumentoId(String tipoDocumentoId) {
		this.tipoDocumentoId = tipoDocumentoId;
	}
	 
	public String getProjetoAnexosVenc() {
		return projetoAnexosVenc;
	}
	 
	public void setProjetoAnexosVenc(String projetoAnexosVenc) {
		this.projetoAnexosVenc = projetoAnexosVenc;
	}
	 
	public String getProjetoAnexosBlob() {
		return projetoAnexosBlob;
	}
	 
	public void setProjetoAnexosBlob(String projetoAnexosBlob) {
		this.projetoAnexosBlob = projetoAnexosBlob;
	}
	 
	public String getProjetoAnexosBlobTipo() {
		return projetoAnexosBlobTipo;
	}
	 
	public void setProjetoAnexosBlobTipo(String projetoAnexosBlobTipo) {
		this.projetoAnexosBlobTipo = projetoAnexosBlobTipo;
	}
	 
	public String getProjetoAnexosBlobName() {
		return projetoAnexosBlobName;
	}
	 
	public void setProjetoAnexosBlobName(String projetoAnexosBlobName) {
		this.projetoAnexosBlobName = projetoAnexosBlobName;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
