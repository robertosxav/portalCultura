package com.portal.model.enuns;

import com.portal.exceptions.PortalException;

public enum TipoPessoaEnum {
	PESSOA_FISICA("PESSOA_FISICA"),
	PESSOA_JURIDICA("PESSOA_JURIDICA");
	
	private String descricao;
	
	TipoPessoaEnum(String descricao) {
		this.descricao	=	descricao;
	}
	
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	
	public static TipoPessoaEnum toEnumDesc(String descricao) {
		if (descricao == null || descricao.isEmpty()) {
			throw new PortalException("Enum inválido: "+descricao);
		}
		
		for(TipoPessoaEnum s : TipoPessoaEnum.values()) {
			if(descricao.equals(s.name())){
				return s;
			}
		}
		
		throw new PortalException("Enum inválido: "+descricao);
	}
}

