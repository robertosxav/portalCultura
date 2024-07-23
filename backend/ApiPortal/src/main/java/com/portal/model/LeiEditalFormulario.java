package com.portal.model;

import java.io.Serializable;

import com.portal.model.enuns.StatusEnum;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lei_edital_formulario",schema="public") 
public class LeiEditalFormulario implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_EDITAL")
	@SequenceGenerator(name = "SEQUENCE_LEI_EDITAL", sequenceName = "public.lei_edital_formulario_id", allocationSize = 1)
	@Column(name = "lei_edital_formulario_id")
	private Long id;

	
	@Column(name = "lei_edital_formulario_ativo",nullable = false)
	private StatusEnum status;

	@ManyToOne
	@JoinColumn(name="lei_edital_id",referencedColumnName  = "lei_edital_id")
	private LeiEdital leiEdital;
} 
