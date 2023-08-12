package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.projeto_responsavel") 
public class ProjetoResponsavel implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_responsavel_id")
	private Long projetoResponsavelId;

	@Column(name = "projeto_responsavel_nome")
	private String projetoResponsavelNome;

	@Column(name = "projeto_responsavel_cpf")
	private String projetoResponsavelCpf;

	@Column(name = "projeto_responsavel_rg")
	private String projetoResponsavelRg;

	@Column(name = "projeto_responsavel_orgexpedit")
	private String projetoResponsavelOrgexpedit;

	@Column(name = "projeto_responsavel_email")
	private String projetoResponsavelEmail;

	@Column(name = "projeto_responsavel_tel")
	private String projetoResponsavelTel;

	@Column(name = "projeto_responsavel_cel")
	private String projetoResponsavelCel;

	@Column(name = "projeto_responsavel_cep")
	private String projetoResponsavelCep;

	@Column(name = "projeto_responsavel_end")
	private String projetoResponsavelEnd;

	@Column(name = "projeto_responsavel_num")
	private String projetoResponsavelNum;

	@Column(name = "projeto_responsavel_comp")
	private String projetoResponsavelComp;

	@Column(name = "projeto_responsavel_bairro")
	private String projetoResponsavelBairro;

	@Column(name = "projeto_responsavel_mun")
	private String projetoResponsavelMun;

	@Column(name = "projeto_responsavel_uf")
	private String projetoResponsavelUf;

	@Column(name = "projeto_responsavel_obs")
	private String projetoResponsavelObs;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoResponsavelId() {
		return projetoResponsavelId;
	}
	 
	public void setProjetoResponsavelId(Long projetoResponsavelId) {
		this.projetoResponsavelId = projetoResponsavelId;
	}
	 
	public String getProjetoResponsavelNome() {
		return projetoResponsavelNome;
	}
	 
	public void setProjetoResponsavelNome(String projetoResponsavelNome) {
		this.projetoResponsavelNome = projetoResponsavelNome;
	}
	 
	public String getProjetoResponsavelCpf() {
		return projetoResponsavelCpf;
	}
	 
	public void setProjetoResponsavelCpf(String projetoResponsavelCpf) {
		this.projetoResponsavelCpf = projetoResponsavelCpf;
	}
	 
	public String getProjetoResponsavelRg() {
		return projetoResponsavelRg;
	}
	 
	public void setProjetoResponsavelRg(String projetoResponsavelRg) {
		this.projetoResponsavelRg = projetoResponsavelRg;
	}
	 
	public String getProjetoResponsavelOrgexpedit() {
		return projetoResponsavelOrgexpedit;
	}
	 
	public void setProjetoResponsavelOrgexpedit(String projetoResponsavelOrgexpedit) {
		this.projetoResponsavelOrgexpedit = projetoResponsavelOrgexpedit;
	}
	 
	public String getProjetoResponsavelEmail() {
		return projetoResponsavelEmail;
	}
	 
	public void setProjetoResponsavelEmail(String projetoResponsavelEmail) {
		this.projetoResponsavelEmail = projetoResponsavelEmail;
	}
	 
	public String getProjetoResponsavelTel() {
		return projetoResponsavelTel;
	}
	 
	public void setProjetoResponsavelTel(String projetoResponsavelTel) {
		this.projetoResponsavelTel = projetoResponsavelTel;
	}
	 
	public String getProjetoResponsavelCel() {
		return projetoResponsavelCel;
	}
	 
	public void setProjetoResponsavelCel(String projetoResponsavelCel) {
		this.projetoResponsavelCel = projetoResponsavelCel;
	}
	 
	public String getProjetoResponsavelCep() {
		return projetoResponsavelCep;
	}
	 
	public void setProjetoResponsavelCep(String projetoResponsavelCep) {
		this.projetoResponsavelCep = projetoResponsavelCep;
	}
	 
	public String getProjetoResponsavelEnd() {
		return projetoResponsavelEnd;
	}
	 
	public void setProjetoResponsavelEnd(String projetoResponsavelEnd) {
		this.projetoResponsavelEnd = projetoResponsavelEnd;
	}
	 
	public String getProjetoResponsavelNum() {
		return projetoResponsavelNum;
	}
	 
	public void setProjetoResponsavelNum(String projetoResponsavelNum) {
		this.projetoResponsavelNum = projetoResponsavelNum;
	}
	 
	public String getProjetoResponsavelComp() {
		return projetoResponsavelComp;
	}
	 
	public void setProjetoResponsavelComp(String projetoResponsavelComp) {
		this.projetoResponsavelComp = projetoResponsavelComp;
	}
	 
	public String getProjetoResponsavelBairro() {
		return projetoResponsavelBairro;
	}
	 
	public void setProjetoResponsavelBairro(String projetoResponsavelBairro) {
		this.projetoResponsavelBairro = projetoResponsavelBairro;
	}
	 
	public String getProjetoResponsavelMun() {
		return projetoResponsavelMun;
	}
	 
	public void setProjetoResponsavelMun(String projetoResponsavelMun) {
		this.projetoResponsavelMun = projetoResponsavelMun;
	}
	 
	public String getProjetoResponsavelUf() {
		return projetoResponsavelUf;
	}
	 
	public void setProjetoResponsavelUf(String projetoResponsavelUf) {
		this.projetoResponsavelUf = projetoResponsavelUf;
	}
	 
	public String getProjetoResponsavelObs() {
		return projetoResponsavelObs;
	}
	 
	public void setProjetoResponsavelObs(String projetoResponsavelObs) {
		this.projetoResponsavelObs = projetoResponsavelObs;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
