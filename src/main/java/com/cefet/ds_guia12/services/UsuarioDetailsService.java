package com.cefet.ds_guia12.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.entity.Usuario;
import com.cefet.ds_guia12.repositories.UsuarioRepository;
import com.cefet.ds_guia12.security.UsuarioDetails;

@Service
public class UsuarioDetailsService implements UserDetailsService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public UsuarioDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        Usuario usuario = usuarioRepository.findByLogin(login)
                .orElseThrow(() -> new UsernameNotFoundException("Usuário não encontrado: " + login));
        return new UsuarioDetails(usuario);
    }
}
