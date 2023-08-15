package com.portal.model;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.portal.model.enuns.StatusEditalEnum;

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
@Table(name = "edital",schema="public") 
public class Edital implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_EDITAL")
	@SequenceGenerator(name = "SEQUENCE_EDITAL", sequenceName = "public.edital_id", allocationSize = 1)
	@Column(name = "edital_id")
	private Long id;

	@NotBlank(message = "Título é obrigatório")
	@Column(name = "edital_titulo", length = 120,nullable = false)
	private String titulo;

	@NotBlank(message = "Observação é obrigatória")
	@Column(name = "edital_observacao",nullable = false)
	private String observacao;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "edital_dta_abertura",nullable = false)
	private LocalDate dataAbertura;

	@JsonFormat(pattern="dd/MM/yyyy")
	@Column(name = "edital_dta_encerramento",nullable = false)
	private LocalDate dataEncerramento;

	@Column(name = "edital_status",nullable = false)
	private StatusEditalEnum statusEdital;
	
	public void iniciar() {
		this.statusEdital = StatusEditalEnum.NOVO;
	}

} 
