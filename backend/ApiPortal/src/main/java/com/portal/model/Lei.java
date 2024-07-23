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
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "lei",schema="public") 
public class Lei implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI")
	@SequenceGenerator(name = "SEQUENCE_LEI", sequenceName = "public.lei_id", allocationSize = 1)
	@Column(name = "lei_id")
	private Long id;

	@NotBlank(message = "Nome da lei é obrigatório")
	@Column(name = "lei_nome",nullable = false)
	private String nome;

	@Column(name = "lei_ativo",nullable = false)
	private StatusEnum status;
	
	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "lei_inc_em",nullable = false)
	private LocalDate incluidoEm;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "lei_alt_em",nullable = false)
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
