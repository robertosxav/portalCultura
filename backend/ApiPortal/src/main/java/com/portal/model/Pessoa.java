package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pessoa",schema="public") 
public class Pessoa implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "pessoa_id")
	private Long pessoaId;

	@Column(name = "pessoa_nome")
	private String pessoaNome;

	@Column(name = "pessoa_cpf")
	private String pessoaCpf;

	@Column(name = "pessoa_rg")
	private String pessoaRg;

	@Column(name = "pessoa_orgao_expeditor")
	private String pessoaOrgaoExpeditor;

	@Column(name = "pessoa_data_nasc")
	private String pessoaDataNasc;

	@Column(name = "pessoa_email")
	private String pessoaEmail;

	@Column(name = "pessoa_email_alter")
	private String pessoaEmailAlter;

	@Column(name = "pessoa_telefone")
	private String pessoaTelefone;

	@Column(name = "pessoa_celular")
	private String pessoaCelular;

	@Column(name = "pessoa_cep")
	private String pessoaCep;

	@Column(name = "pessoa_endereco")
	private String pessoaEndereco;

	@Column(name = "pessoa_numero")
	private String pessoaNumero;

	@Column(name = "pessoa_complemento")
	private String pessoaComplemento;

	@Column(name = "pessoa_bairro")
	private String pessoaBairro;

	@Column(name = "pessoa_municipio")
	private String pessoaMunicipio;

	@Column(name = "pessoa_uf")
	private String pessoaUf;

	public Long getPessoaId() {
		return pessoaId;
	}
	 
	public void setPessoaId(Long pessoaId) {
		this.pessoaId = pessoaId;
	}
	 
	public String getPessoaNome() {
		return pessoaNome;
	}
	 
	public void setPessoaNome(String pessoaNome) {
		this.pessoaNome = pessoaNome;
	}
	 
	public String getPessoaCpf() {
		return pessoaCpf;
	}
	 
	public void setPessoaCpf(String pessoaCpf) {
		this.pessoaCpf = pessoaCpf;
	}
	 
	public String getPessoaRg() {
		return pessoaRg;
	}
	 
	public void setPessoaRg(String pessoaRg) {
		this.pessoaRg = pessoaRg;
	}
	 
	public String getPessoaOrgaoExpeditor() {
		return pessoaOrgaoExpeditor;
	}
	 
	public void setPessoaOrgaoExpeditor(String pessoaOrgaoExpeditor) {
		this.pessoaOrgaoExpeditor = pessoaOrgaoExpeditor;
	}
	 
	public String getPessoaDataNasc() {
		return pessoaDataNasc;
	}
	 
	public void setPessoaDataNasc(String pessoaDataNasc) {
		this.pessoaDataNasc = pessoaDataNasc;
	}
	 
	public String getPessoaEmail() {
		return pessoaEmail;
	}
	 
	public void setPessoaEmail(String pessoaEmail) {
		this.pessoaEmail = pessoaEmail;
	}
	 
	public String getPessoaEmailAlter() {
		return pessoaEmailAlter;
	}
	 
	public void setPessoaEmailAlter(String pessoaEmailAlter) {
		this.pessoaEmailAlter = pessoaEmailAlter;
	}
	 
	public String getPessoaTelefone() {
		return pessoaTelefone;
	}
	 
	public void setPessoaTelefone(String pessoaTelefone) {
		this.pessoaTelefone = pessoaTelefone;
	}
	 
	public String getPessoaCelular() {
		return pessoaCelular;
	}
	 
	public void setPessoaCelular(String pessoaCelular) {
		this.pessoaCelular = pessoaCelular;
	}
	 
	public String getPessoaCep() {
		return pessoaCep;
	}
	 
	public void setPessoaCep(String pessoaCep) {
		this.pessoaCep = pessoaCep;
	}
	 
	public String getPessoaEndereco() {
		return pessoaEndereco;
	}
	 
	public void setPessoaEndereco(String pessoaEndereco) {
		this.pessoaEndereco = pessoaEndereco;
	}
	 
	public String getPessoaNumero() {
		return pessoaNumero;
	}
	 
	public void setPessoaNumero(String pessoaNumero) {
		this.pessoaNumero = pessoaNumero;
	}
	 
	public String getPessoaComplemento() {
		return pessoaComplemento;
	}
	 
	public void setPessoaComplemento(String pessoaComplemento) {
		this.pessoaComplemento = pessoaComplemento;
	}
	 
	public String getPessoaBairro() {
		return pessoaBairro;
	}
	 
	public void setPessoaBairro(String pessoaBairro) {
		this.pessoaBairro = pessoaBairro;
	}
	 
	public String getPessoaMunicipio() {
		return pessoaMunicipio;
	}
	 
	public void setPessoaMunicipio(String pessoaMunicipio) {
		this.pessoaMunicipio = pessoaMunicipio;
	}
	 
	public String getPessoaUf() {
		return pessoaUf;
	}
	 
	public void setPessoaUf(String pessoaUf) {
		this.pessoaUf = pessoaUf;
	}
	 

} 
