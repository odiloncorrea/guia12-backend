package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.Usuario;

public class UsuarioMinDTO {

	private Long id;
	private String nome;

	public UsuarioMinDTO() {
	}

	public UsuarioMinDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
	}

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}
}
