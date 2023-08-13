package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "projeto_equipe",schema="public") 
public class ProjetoEquipe implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_equipe_id")
	private Long projetoEquipeId;

	@Column(name = "projeto_equipe_nome")
	private String projetoEquipeNome;

	@Column(name = "projeto_equipe_funcao")
	private String projetoEquipeFuncao;

	@Column(name = "projeto_equipe_mini_cv")
	private String projetoEquipeMiniCv;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoEquipeId() {
		return projetoEquipeId;
	}
	 
	public void setProjetoEquipeId(Long projetoEquipeId) {
		this.projetoEquipeId = projetoEquipeId;
	}
	 
	public String getProjetoEquipeNome() {
		return projetoEquipeNome;
	}
	 
	public void setProjetoEquipeNome(String projetoEquipeNome) {
		this.projetoEquipeNome = projetoEquipeNome;
	}
	 
	public String getProjetoEquipeFuncao() {
		return projetoEquipeFuncao;
	}
	 
	public void setProjetoEquipeFuncao(String projetoEquipeFuncao) {
		this.projetoEquipeFuncao = projetoEquipeFuncao;
	}
	 
	public String getProjetoEquipeMiniCv() {
		return projetoEquipeMiniCv;
	}
	 
	public void setProjetoEquipeMiniCv(String projetoEquipeMiniCv) {
		this.projetoEquipeMiniCv = projetoEquipeMiniCv;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
