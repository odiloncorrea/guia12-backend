package com.cefet.ds_guia12.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.ds_guia12.entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
    boolean existsByLogin(String login);
    
    Optional<Usuario> findByLogin(String login);
}