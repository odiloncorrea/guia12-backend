package com.cefet.ds_guia12.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

import com.cefet.ds_guia12.entity.Pedido;

public class PedidoDTO {

	private Long id;
	private LocalDate data;	
	private double valor;	
	private UsuarioMinDTO usuario;
	
	public PedidoDTO() {
	}
	
	public PedidoDTO(Pedido pedido) {
		this.id = pedido.getId();
		this.data = pedido.getData();
		this.valor = pedido.getValor();
		this.usuario = new UsuarioMinDTO(pedido.getUsuario());
	}

	public Long getId() {
		return id;
	}

	public LocalDate getData() {
		return data;
	}

	public double getValor() {
		return valor;
	}

	public UsuarioMinDTO getUsuario() {
		return usuario;
	}	
}
