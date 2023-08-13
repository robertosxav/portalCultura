package com.portal.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.model.enuns.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
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
@Table(name = "acao_categoria",schema="public") 
public class AcaoCategoria implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_ACAO_CATEGORIA")
	@SequenceGenerator(name = "SEQUENCE_ACAO_CATEGORIA", sequenceName = "public.acao_categoria_id", allocationSize = 1)
	@Column(name = "acao_categoria_id")
	private Long id;

	@Column(name = "acao_categoria_nome",length = 120)
	private String nome;

	@Column(name = "acao_categoria_ativo")
	private StatusEnum status;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "acao_categoria_inc_em")
	private LocalDate incluidoEm;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "acao_categoria_alt_em")
	private LocalDate alteradoEm;
	
	public void ativar() {
		this.incluidoEm = LocalDate.now();
		this.status = StatusEnum.ATIVO;
	}

	public void inativar() {
		this.alteradoEm = LocalDate.now();
		this.status = StatusEnum.INATIVO;
	}

	
} 
