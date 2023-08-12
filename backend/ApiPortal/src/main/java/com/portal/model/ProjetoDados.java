package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "public.projeto_dados") 
public class ProjetoDados implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_dados_id")
	private Long projetoDadosId;

	@Column(name = "projeto_id")
	private String projetoId;

	@Column(name = "projeto_dados_resumo")
	private String projetoDadosResumo;

	@Column(name = "projeto_dados_descricao")
	private String projetoDadosDescricao;

	@Column(name = "projeto_dados_objetivos")
	private String projetoDadosObjetivos;

	@Column(name = "projeto_dados_justificativa")
	private String projetoDadosJustificativa;

	@Column(name = "projeto_dados_estrategia")
	private String projetoDadosEstrategia;

	@Column(name = "projeto_dados_parcerias")
	private String projetoDadosParcerias;

	@Column(name = "projeto_dados_acessibilidade")
	private String projetoDadosAcessibilidade;

	@Column(name = "projeto_dados_produto")
	private String projetoDadosProduto;

	public Long getProjetoDadosId() {
		return projetoDadosId;
	}
	 
	public void setProjetoDadosId(Long projetoDadosId) {
		this.projetoDadosId = projetoDadosId;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 
	public String getProjetoDadosResumo() {
		return projetoDadosResumo;
	}
	 
	public void setProjetoDadosResumo(String projetoDadosResumo) {
		this.projetoDadosResumo = projetoDadosResumo;
	}
	 
	public String getProjetoDadosDescricao() {
		return projetoDadosDescricao;
	}
	 
	public void setProjetoDadosDescricao(String projetoDadosDescricao) {
		this.projetoDadosDescricao = projetoDadosDescricao;
	}
	 
	public String getProjetoDadosObjetivos() {
		return projetoDadosObjetivos;
	}
	 
	public void setProjetoDadosObjetivos(String projetoDadosObjetivos) {
		this.projetoDadosObjetivos = projetoDadosObjetivos;
	}
	 
	public String getProjetoDadosJustificativa() {
		return projetoDadosJustificativa;
	}
	 
	public void setProjetoDadosJustificativa(String projetoDadosJustificativa) {
		this.projetoDadosJustificativa = projetoDadosJustificativa;
	}
	 
	public String getProjetoDadosEstrategia() {
		return projetoDadosEstrategia;
	}
	 
	public void setProjetoDadosEstrategia(String projetoDadosEstrategia) {
		this.projetoDadosEstrategia = projetoDadosEstrategia;
	}
	 
	public String getProjetoDadosParcerias() {
		return projetoDadosParcerias;
	}
	 
	public void setProjetoDadosParcerias(String projetoDadosParcerias) {
		this.projetoDadosParcerias = projetoDadosParcerias;
	}
	 
	public String getProjetoDadosAcessibilidade() {
		return projetoDadosAcessibilidade;
	}
	 
	public void setProjetoDadosAcessibilidade(String projetoDadosAcessibilidade) {
		this.projetoDadosAcessibilidade = projetoDadosAcessibilidade;
	}
	 
	public String getProjetoDadosProduto() {
		return projetoDadosProduto;
	}
	 
	public void setProjetoDadosProduto(String projetoDadosProduto) {
		this.projetoDadosProduto = projetoDadosProduto;
	}
	 

} 
