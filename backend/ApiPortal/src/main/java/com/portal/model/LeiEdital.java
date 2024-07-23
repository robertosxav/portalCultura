package com.portal.model;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "lei_edital",schema="public") 
public class LeiEdital implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQUENCE_LEI_EDITAL")
	@SequenceGenerator(name = "SEQUENCE_LEI_EDITAL", sequenceName = "public.lei_edital_id", allocationSize = 1)
	@Column(name = "lei_edital_id")
	private Long id;

	@NotBlank(message = "Nome do edital é obrigatório")
	@Column(name = "lei_edital_nome",nullable = false)
	private String nome;

	@ManyToOne
	@JoinColumn(name="lei_id",referencedColumnName  = "lei_id")
	private Lei lei;
} 
