package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.Produto;
import com.cefet.ds_guia12.entity.Tipo;

public class ProdutoDTO {

	private Long id;
	private String descricao;
	private double valor;
	private Integer estoque;	
	private Tipo tipo;
	
	public ProdutoDTO() {
	}	
	
	public ProdutoDTO(Produto produto) {
		this.id = produto.getId();
		this.descricao = produto.getDescricao();
		this.valor = produto.getValor();
		this.estoque = produto.getEstoque();
		this.tipo = produto.getTipo();
	}
	
	public Long getId() {
		return id;
	}
	public String getDescricao() {
		return descricao;
	}
	public double getValor() {
		return valor;
	}
	public Integer getEstoque() {
		return estoque;
	}
	public Tipo getTipo() {
		return tipo;
	}
	
}
