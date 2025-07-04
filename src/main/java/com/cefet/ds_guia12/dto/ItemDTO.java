package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.Item;

public class ItemDTO {

	private Long id;
	private double valor;	
	private int quantidade;	
	private Long idPedido; 
	private ProdutoMinDTO produto;
	
	public ItemDTO() {
	}
	
	public ItemDTO(Item item) {
		this.id = item.getId();
		this.valor = item.getValor();
		this.quantidade = item.getQuantidade();
		this.idPedido = item.getPedido().getId();
		this.produto = new ProdutoMinDTO(item.getProduto());
	}

	public Long getId() {
		return id;
	}

	public double getValor() {
		return valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public Long getIdPedido() {
		return idPedido;
	}

	public ProdutoMinDTO getProduto() {
		return produto;
	}
	
}
