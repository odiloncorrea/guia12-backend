package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.Tipo;

public class TipoDTO {
    private Long id; 
    private String descricao;
    
    public TipoDTO() {
    }    
    
    public TipoDTO(Tipo tipo) {
        this.id = tipo.getId();
        this.descricao = tipo.getDescricao();
    }

	public Long getId() {
		return id;
	}

	public String getDescricao() {
		return descricao;
	}

}
