package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.Produto;

public class ProdutoMinDTO {

	private Long id;
	private String descricao;
	
	public ProdutoMinDTO() {
	}	
	
	public ProdutoMinDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
	}
	
	public Long getId() {
		return id;
	}
	
	public String getDescricao() {
		return descricao;
	}	
}
