package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.projeto_plano_dist") 
public class ProjetoPlanoDist implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_plano_dist_id")
	private Long projetoPlanoDistId;

	@Column(name = "projeto_plano_dist_espaco")
	private String projetoPlanoDistEspaco;

	@Column(name = "projeto_plano_dist_capacidade")
	private String projetoPlanoDistCapacidade;

	@Column(name = "projeto_plano_dist_publico")
	private String projetoPlanoDistPublico;

	@Column(name = "projeto_plano_dist_acesso")
	private Integer projetoPlanoDistAcesso;

	@Column(name = "projeto_plano_dist_dta_ini")
	private String projetoPlanoDistDtaIni;

	@Column(name = "projeto_plano_dist_dta_fim")
	private String projetoPlanoDistDtaFim;

	@Column(name = "projeto_plano_dist_dta_rel_ini")
	private String projetoPlanoDistDtaRelIni;

	@Column(name = "projeto_plano_dist_dta_rel_fim")
	private Integer projetoPlanoDistDtaRelFim;

	@Column(name = "projeto_plano_dist_comu")
	private String projetoPlanoDistComu;

	@Column(name = "projeto_plano_dist_rec_bruta")
	private String projetoPlanoDistRecBruta;

	@Column(name = "projeto_plano_dist_rec_liq")
	private String projetoPlanoDistRecLiq;

	@Column(name = "projeto_plano_dist_obs")
	private String projetoPlanoDistObs;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoPlanoDistId() {
		return projetoPlanoDistId;
	}
	 
	public void setProjetoPlanoDistId(Long projetoPlanoDistId) {
		this.projetoPlanoDistId = projetoPlanoDistId;
	}
	 
	public String getProjetoPlanoDistEspaco() {
		return projetoPlanoDistEspaco;
	}
	 
	public void setProjetoPlanoDistEspaco(String projetoPlanoDistEspaco) {
		this.projetoPlanoDistEspaco = projetoPlanoDistEspaco;
	}
	 
	public String getProjetoPlanoDistCapacidade() {
		return projetoPlanoDistCapacidade;
	}
	 
	public void setProjetoPlanoDistCapacidade(String projetoPlanoDistCapacidade) {
		this.projetoPlanoDistCapacidade = projetoPlanoDistCapacidade;
	}
	 
	public String getProjetoPlanoDistPublico() {
		return projetoPlanoDistPublico;
	}
	 
	public void setProjetoPlanoDistPublico(String projetoPlanoDistPublico) {
		this.projetoPlanoDistPublico = projetoPlanoDistPublico;
	}
	 
	public Integer getProjetoPlanoDistAcesso() {
		return projetoPlanoDistAcesso;
	}
	 
	public void setProjetoPlanoDistAcesso(Integer projetoPlanoDistAcesso) {
		this.projetoPlanoDistAcesso = projetoPlanoDistAcesso;
	}
	 
	public String getProjetoPlanoDistDtaIni() {
		return projetoPlanoDistDtaIni;
	}
	 
	public void setProjetoPlanoDistDtaIni(String projetoPlanoDistDtaIni) {
		this.projetoPlanoDistDtaIni = projetoPlanoDistDtaIni;
	}
	 
	public String getProjetoPlanoDistDtaFim() {
		return projetoPlanoDistDtaFim;
	}
	 
	public void setProjetoPlanoDistDtaFim(String projetoPlanoDistDtaFim) {
		this.projetoPlanoDistDtaFim = projetoPlanoDistDtaFim;
	}
	 
	public String getProjetoPlanoDistDtaRelIni() {
		return projetoPlanoDistDtaRelIni;
	}
	 
	public void setProjetoPlanoDistDtaRelIni(String projetoPlanoDistDtaRelIni) {
		this.projetoPlanoDistDtaRelIni = projetoPlanoDistDtaRelIni;
	}
	 
	public Integer getProjetoPlanoDistDtaRelFim() {
		return projetoPlanoDistDtaRelFim;
	}
	 
	public void setProjetoPlanoDistDtaRelFim(Integer projetoPlanoDistDtaRelFim) {
		this.projetoPlanoDistDtaRelFim = projetoPlanoDistDtaRelFim;
	}
	 
	public String getProjetoPlanoDistComu() {
		return projetoPlanoDistComu;
	}
	 
	public void setProjetoPlanoDistComu(String projetoPlanoDistComu) {
		this.projetoPlanoDistComu = projetoPlanoDistComu;
	}
	 
	public String getProjetoPlanoDistRecBruta() {
		return projetoPlanoDistRecBruta;
	}
	 
	public void setProjetoPlanoDistRecBruta(String projetoPlanoDistRecBruta) {
		this.projetoPlanoDistRecBruta = projetoPlanoDistRecBruta;
	}
	 
	public String getProjetoPlanoDistRecLiq() {
		return projetoPlanoDistRecLiq;
	}
	 
	public void setProjetoPlanoDistRecLiq(String projetoPlanoDistRecLiq) {
		this.projetoPlanoDistRecLiq = projetoPlanoDistRecLiq;
	}
	 
	public String getProjetoPlanoDistObs() {
		return projetoPlanoDistObs;
	}
	 
	public void setProjetoPlanoDistObs(String projetoPlanoDistObs) {
		this.projetoPlanoDistObs = projetoPlanoDistObs;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
