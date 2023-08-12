package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.projeto_coordenador") 
public class ProjetoCoordenador implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_coordenador_id")
	private Long projetoCoordenadorId;

	@Column(name = "projeto_coordenador_nome")
	private String projetoCoordenadorNome;

	@Column(name = "projeto_coordenador_cpf")
	private String projetoCoordenadorCpf;

	@Column(name = "projeto_coordenador_rg")
	private String projetoCoordenadorRg;

	@Column(name = "projeto_coordenador_orgexpedit")
	private String projetoCoordenadorOrgexpedit;

	@Column(name = "projeto_coordenador_email")
	private String projetoCoordenadorEmail;

	@Column(name = "projeto_coordenador_tel")
	private String projetoCoordenadorTel;

	@Column(name = "projeto_coordenador_cel")
	private String projetoCoordenadorCel;

	@Column(name = "projeto_coordenador_cep")
	private String projetoCoordenadorCep;

	@Column(name = "projeto_coordenador_end")
	private String projetoCoordenadorEnd;

	@Column(name = "projeto_coordenador_end_num")
	private String projetoCoordenadorEndNum;

	@Column(name = "projeto_coordenador_end_comp")
	private String projetoCoordenadorEndComp;

	@Column(name = "projeto_coordenador_end_bairro")
	private String projetoCoordenadorEndBairro;

	@Column(name = "projeto_coordenador_end_mun")
	private String projetoCoordenadorEndMun;

	@Column(name = "projeto_coordenador_end_uf")
	private Integer projetoCoordenadorEndUf;

	@Column(name = "projeto_coordenador_obs")
	private String projetoCoordenadorObs;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoCoordenadorId() {
		return projetoCoordenadorId;
	}
	 
	public void setProjetoCoordenadorId(Long projetoCoordenadorId) {
		this.projetoCoordenadorId = projetoCoordenadorId;
	}
	 
	public String getProjetoCoordenadorNome() {
		return projetoCoordenadorNome;
	}
	 
	public void setProjetoCoordenadorNome(String projetoCoordenadorNome) {
		this.projetoCoordenadorNome = projetoCoordenadorNome;
	}
	 
	public String getProjetoCoordenadorCpf() {
		return projetoCoordenadorCpf;
	}
	 
	public void setProjetoCoordenadorCpf(String projetoCoordenadorCpf) {
		this.projetoCoordenadorCpf = projetoCoordenadorCpf;
	}
	 
	public String getProjetoCoordenadorRg() {
		return projetoCoordenadorRg;
	}
	 
	public void setProjetoCoordenadorRg(String projetoCoordenadorRg) {
		this.projetoCoordenadorRg = projetoCoordenadorRg;
	}
	 
	public String getProjetoCoordenadorOrgexpedit() {
		return projetoCoordenadorOrgexpedit;
	}
	 
	public void setProjetoCoordenadorOrgexpedit(String projetoCoordenadorOrgexpedit) {
		this.projetoCoordenadorOrgexpedit = projetoCoordenadorOrgexpedit;
	}
	 
	public String getProjetoCoordenadorEmail() {
		return projetoCoordenadorEmail;
	}
	 
	public void setProjetoCoordenadorEmail(String projetoCoordenadorEmail) {
		this.projetoCoordenadorEmail = projetoCoordenadorEmail;
	}
	 
	public String getProjetoCoordenadorTel() {
		return projetoCoordenadorTel;
	}
	 
	public void setProjetoCoordenadorTel(String projetoCoordenadorTel) {
		this.projetoCoordenadorTel = projetoCoordenadorTel;
	}
	 
	public String getProjetoCoordenadorCel() {
		return projetoCoordenadorCel;
	}
	 
	public void setProjetoCoordenadorCel(String projetoCoordenadorCel) {
		this.projetoCoordenadorCel = projetoCoordenadorCel;
	}
	 
	public String getProjetoCoordenadorCep() {
		return projetoCoordenadorCep;
	}
	 
	public void setProjetoCoordenadorCep(String projetoCoordenadorCep) {
		this.projetoCoordenadorCep = projetoCoordenadorCep;
	}
	 
	public String getProjetoCoordenadorEnd() {
		return projetoCoordenadorEnd;
	}
	 
	public void setProjetoCoordenadorEnd(String projetoCoordenadorEnd) {
		this.projetoCoordenadorEnd = projetoCoordenadorEnd;
	}
	 
	public String getProjetoCoordenadorEndNum() {
		return projetoCoordenadorEndNum;
	}
	 
	public void setProjetoCoordenadorEndNum(String projetoCoordenadorEndNum) {
		this.projetoCoordenadorEndNum = projetoCoordenadorEndNum;
	}
	 
	public String getProjetoCoordenadorEndComp() {
		return projetoCoordenadorEndComp;
	}
	 
	public void setProjetoCoordenadorEndComp(String projetoCoordenadorEndComp) {
		this.projetoCoordenadorEndComp = projetoCoordenadorEndComp;
	}
	 
	public String getProjetoCoordenadorEndBairro() {
		return projetoCoordenadorEndBairro;
	}
	 
	public void setProjetoCoordenadorEndBairro(String projetoCoordenadorEndBairro) {
		this.projetoCoordenadorEndBairro = projetoCoordenadorEndBairro;
	}
	 
	public String getProjetoCoordenadorEndMun() {
		return projetoCoordenadorEndMun;
	}
	 
	public void setProjetoCoordenadorEndMun(String projetoCoordenadorEndMun) {
		this.projetoCoordenadorEndMun = projetoCoordenadorEndMun;
	}
	 
	public Integer getProjetoCoordenadorEndUf() {
		return projetoCoordenadorEndUf;
	}
	 
	public void setProjetoCoordenadorEndUf(Integer projetoCoordenadorEndUf) {
		this.projetoCoordenadorEndUf = projetoCoordenadorEndUf;
	}
	 
	public String getProjetoCoordenadorObs() {
		return projetoCoordenadorObs;
	}
	 
	public void setProjetoCoordenadorObs(String projetoCoordenadorObs) {
		this.projetoCoordenadorObs = projetoCoordenadorObs;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
