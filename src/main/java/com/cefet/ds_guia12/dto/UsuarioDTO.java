package com.cefet.ds_guia12.dto;

import com.cefet.ds_guia12.entity.NivelAcesso;
import com.cefet.ds_guia12.entity.Usuario;
import com.fasterxml.jackson.annotation.JsonProperty;

public class UsuarioDTO {

    private Long id; 
    private String nome;
    private String login;
    //impede que a senha seja exposta
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String senha;
    private NivelAcesso nivelAcesso;

    public UsuarioDTO() {
    }    
    
    public UsuarioDTO(Usuario usuario) {
        this.id = usuario.getId();
        this.nome = usuario.getNome();
        this.login = usuario.getLogin();
        this.senha = usuario.getSenha();
        this.nivelAcesso = usuario.getNivelAcesso();
    }
    
	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}	

	public String getLogin() {
		return login;
	}

	public String getSenha() {
		return senha;
	}

	public NivelAcesso getNivelAcesso() {
		return nivelAcesso;
	}    
}
