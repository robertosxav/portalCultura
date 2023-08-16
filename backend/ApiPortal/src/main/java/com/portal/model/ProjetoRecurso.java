package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "projeto_recurso",schema="public") 
public class ProjetoRecurso implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "projeto_recurso_id")
	private Long projetoRecursoId;

	@Column(name = "projeto_recurso_pessoal")
	private String projetoRecursoPessoal;

	@Column(name = "projeto_recurso_estrutura")
	private String projetoRecursoEstrutura;

	@Column(name = "projeto_recurso_logistica")
	private String projetoRecursoLogistica;

	@Column(name = "projeto_recurso_divulgacao")
	private String projetoRecursoDivulgacao;

	@Column(name = "projeto_recurso_despesas")
	private String projetoRecursoDespesas;

	@Column(name = "projeto_recurso_imposto")
	private String projetoRecursoImposto;

	@Column(name = "projeto_recurso_total")
	private String projetoRecursoTotal;

	@Column(name = "projeto_recurso_solicitado")
	private String projetoRecursoSolicitado;

	@Column(name = "projeto_recurso_outrasleis")
	private String projetoRecursoOutrasleis;

	@Column(name = "projeto_recurso_proprio")
	private String projetoRecursoProprio;

	@Column(name = "projeto_recurso_outros")
	private String projetoRecursoOutros;

	@Column(name = "projeto_recurso_prj_total")
	private String projetoRecursoPrjTotal;

	@Column(name = "projeto_recurso_contemplado")
	private Integer projetoRecursoContemplado;

	@Column(name = "projeto_recurso_edicao")
	private String projetoRecursoEdicao;

	@Column(name = "projeto_recurso_patrocinado")
	private Integer projetoRecursoPatrocinado;

	@Column(name = "projeto_recurso_propjarec")
	private Integer projetoRecursoPropjarec;

	@Column(name = "projeto_id")
	private String projetoId;

	public Long getProjetoRecursoId() {
		return projetoRecursoId;
	}
	 
	public void setProjetoRecursoId(Long projetoRecursoId) {
		this.projetoRecursoId = projetoRecursoId;
	}
	 
	public String getProjetoRecursoPessoal() {
		return projetoRecursoPessoal;
	}
	 
	public void setProjetoRecursoPessoal(String projetoRecursoPessoal) {
		this.projetoRecursoPessoal = projetoRecursoPessoal;
	}
	 
	public String getProjetoRecursoEstrutura() {
		return projetoRecursoEstrutura;
	}
	 
	public void setProjetoRecursoEstrutura(String projetoRecursoEstrutura) {
		this.projetoRecursoEstrutura = projetoRecursoEstrutura;
	}
	 
	public String getProjetoRecursoLogistica() {
		return projetoRecursoLogistica;
	}
	 
	public void setProjetoRecursoLogistica(String projetoRecursoLogistica) {
		this.projetoRecursoLogistica = projetoRecursoLogistica;
	}
	 
	public String getProjetoRecursoDivulgacao() {
		return projetoRecursoDivulgacao;
	}
	 
	public void setProjetoRecursoDivulgacao(String projetoRecursoDivulgacao) {
		this.projetoRecursoDivulgacao = projetoRecursoDivulgacao;
	}
	 
	public String getProjetoRecursoDespesas() {
		return projetoRecursoDespesas;
	}
	 
	public void setProjetoRecursoDespesas(String projetoRecursoDespesas) {
		this.projetoRecursoDespesas = projetoRecursoDespesas;
	}
	 
	public String getProjetoRecursoImposto() {
		return projetoRecursoImposto;
	}
	 
	public void setProjetoRecursoImposto(String projetoRecursoImposto) {
		this.projetoRecursoImposto = projetoRecursoImposto;
	}
	 
	public String getProjetoRecursoTotal() {
		return projetoRecursoTotal;
	}
	 
	public void setProjetoRecursoTotal(String projetoRecursoTotal) {
		this.projetoRecursoTotal = projetoRecursoTotal;
	}
	 
	public String getProjetoRecursoSolicitado() {
		return projetoRecursoSolicitado;
	}
	 
	public void setProjetoRecursoSolicitado(String projetoRecursoSolicitado) {
		this.projetoRecursoSolicitado = projetoRecursoSolicitado;
	}
	 
	public String getProjetoRecursoOutrasleis() {
		return projetoRecursoOutrasleis;
	}
	 
	public void setProjetoRecursoOutrasleis(String projetoRecursoOutrasleis) {
		this.projetoRecursoOutrasleis = projetoRecursoOutrasleis;
	}
	 
	public String getProjetoRecursoProprio() {
		return projetoRecursoProprio;
	}
	 
	public void setProjetoRecursoProprio(String projetoRecursoProprio) {
		this.projetoRecursoProprio = projetoRecursoProprio;
	}
	 
	public String getProjetoRecursoOutros() {
		return projetoRecursoOutros;
	}
	 
	public void setProjetoRecursoOutros(String projetoRecursoOutros) {
		this.projetoRecursoOutros = projetoRecursoOutros;
	}
	 
	public String getProjetoRecursoPrjTotal() {
		return projetoRecursoPrjTotal;
	}
	 
	public void setProjetoRecursoPrjTotal(String projetoRecursoPrjTotal) {
		this.projetoRecursoPrjTotal = projetoRecursoPrjTotal;
	}
	 
	public Integer getProjetoRecursoContemplado() {
		return projetoRecursoContemplado;
	}
	 
	public void setProjetoRecursoContemplado(Integer projetoRecursoContemplado) {
		this.projetoRecursoContemplado = projetoRecursoContemplado;
	}
	 
	public String getProjetoRecursoEdicao() {
		return projetoRecursoEdicao;
	}
	 
	public void setProjetoRecursoEdicao(String projetoRecursoEdicao) {
		this.projetoRecursoEdicao = projetoRecursoEdicao;
	}
	 
	public Integer getProjetoRecursoPatrocinado() {
		return projetoRecursoPatrocinado;
	}
	 
	public void setProjetoRecursoPatrocinado(Integer projetoRecursoPatrocinado) {
		this.projetoRecursoPatrocinado = projetoRecursoPatrocinado;
	}
	 
	public Integer getProjetoRecursoPropjarec() {
		return projetoRecursoPropjarec;
	}
	 
	public void setProjetoRecursoPropjarec(Integer projetoRecursoPropjarec) {
		this.projetoRecursoPropjarec = projetoRecursoPropjarec;
	}
	 
	public String getProjetoId() {
		return projetoId;
	}
	 
	public void setProjetoId(String projetoId) {
		this.projetoId = projetoId;
	}
	 

} 
