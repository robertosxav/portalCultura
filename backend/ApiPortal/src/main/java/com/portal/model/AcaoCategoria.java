package com.portal.model;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "acao_categoria",schema="public") 
public class AcaoCategoria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "acao_categoria_id")
	private Long id;

	@Column(name = "acao_categoria_nome")
	private String nome;

	@Column(name = "acao_categoria_ativo")
	private Integer ativo;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acao_categoria_inc_em")
	private Date incluidoEm;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "acao_categoria_alt_em")
	private Date aletradoEm;



} 
