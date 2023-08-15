package com.portal.dto;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PessoaDto implements Serializable{ 
	
	private static final long serialVersionUID = 1L;

	private String nome;

	private String cpf;
	
	private String email;
	
	private String celular;
	
	private String senha;
}
