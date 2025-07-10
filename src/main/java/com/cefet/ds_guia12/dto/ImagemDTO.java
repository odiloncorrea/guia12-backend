package com.cefet.ds_guia12.dto;

import org.springframework.beans.factory.annotation.Value;

import com.cefet.ds_guia12.entity.Imagem;

public class ImagemDTO {
    private Long id; 
    private String nome;
    
    @Value("${app.url.base}")
    private String baseUrl;
    
    public ImagemDTO() {
    }    
    
    public ImagemDTO(Imagem arquivo) {
        this.id = arquivo.getId();
        this.nome = arquivo.getNome();
    }

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
	
	public String getUrlImagem() {
		return this.baseUrl + nome;
	}

}
