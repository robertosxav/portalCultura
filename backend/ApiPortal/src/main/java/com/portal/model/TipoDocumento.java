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
@Table(name = "tipo_documento") 
public class TipoDocumento implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_TIPO_DOCUMENTO")
	@SequenceGenerator(name = "SEQUENCE_TIPO_DOCUMENTO", sequenceName = "public.tipo_documento_id", allocationSize = 1)
	@Column(name = "tipo_documento_id")
	private Long id;

	@Column(name = "tipo_documento_nome",length = 120,nullable = false)
	private String nomeDocumento;

	@Column(name = "tipo_documento_ativo",nullable = false)
	private StatusEnum status;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "tipo_documento_inc_em",nullable = false)
	private LocalDate incluidoEm;

	@JsonFormat(pattern = "dd/MM/yyyy")
	@Column(name = "tipo_documento_alt_em",nullable = false)
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
