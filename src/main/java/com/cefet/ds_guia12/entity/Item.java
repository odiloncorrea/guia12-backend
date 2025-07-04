package com.cefet.ds_guia12.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="tb_item")
public class Item {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable = false) 
	private double valor;	

	@Column(nullable = false) 
	private int quantidade;	
	
	@ManyToOne 
	@JoinColumn(name = "pedido_id", nullable = false) 
	private Pedido pedido;

	@ManyToOne 
	@JoinColumn(name = "produto_id", nullable = false) 
	private Produto produto;

	public Item() {

	}
	
	public Item(Long id, double valor, int quantidade, Pedido pedido, Produto produto) {
		this.id = id;
		this.valor = valor;
		this.quantidade = quantidade;
		this.pedido = pedido;
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}	
}
