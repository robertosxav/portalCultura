package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "edital",schema="public") 
public class Edital implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "edital_id")
	private Long editalId;

	@Column(name = "edital_titulo")
	private String editalTitulo;

	@Column(name = "edital_observacao")
	private String editalObservacao;

	@Column(name = "edital_dta_abertura")
	private String editalDtaAbertura;

	@Column(name = "edital_dta_encerramento")
	private String editalDtaEncerramento;

	@Column(name = "edital_status")
	private Integer editalStatus;

	public Long getEditalId() {
		return editalId;
	}
	 
	public void setEditalId(Long editalId) {
		this.editalId = editalId;
	}
	 
	public String getEditalTitulo() {
		return editalTitulo;
	}
	 
	public void setEditalTitulo(String editalTitulo) {
		this.editalTitulo = editalTitulo;
	}
	 
	public String getEditalObservacao() {
		return editalObservacao;
	}
	 
	public void setEditalObservacao(String editalObservacao) {
		this.editalObservacao = editalObservacao;
	}
	 
	public String getEditalDtaAbertura() {
		return editalDtaAbertura;
	}
	 
	public void setEditalDtaAbertura(String editalDtaAbertura) {
		this.editalDtaAbertura = editalDtaAbertura;
	}
	 
	public String getEditalDtaEncerramento() {
		return editalDtaEncerramento;
	}
	 
	public void setEditalDtaEncerramento(String editalDtaEncerramento) {
		this.editalDtaEncerramento = editalDtaEncerramento;
	}
	 
	public Integer getEditalStatus() {
		return editalStatus;
	}
	 
	public void setEditalStatus(Integer editalStatus) {
		this.editalStatus = editalStatus;
	}
	 

} 
