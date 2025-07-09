package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.UsuarioDTO;
import com.cefet.ds_guia12.entity.Usuario;
import com.cefet.ds_guia12.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UsuarioService {
	
    @Autowired
    private UsuarioRepository usuarioRepository;
    
    @Autowired
    private PasswordEncoder passwordEncoder;
    
    public UsuarioService() {
    } 
    
	// Listar
	public List<UsuarioDTO> findAll() {
		List<Usuario> lista = usuarioRepository.findAll();
		return lista.stream().map(UsuarioDTO::new).toList();
	}

	// Buscar por ID
	public UsuarioDTO findById(Long id) {
		Usuario objeto = usuarioRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
		return new UsuarioDTO(objeto);
	}  
	
	// Inserir 
    public UsuarioDTO insert(UsuarioDTO dto) {
   	 if (usuarioRepository.existsByLogin(dto.getLogin())) {
            throw new IllegalArgumentException("Login já existe.");
        }
        
        Usuario usuario = new Usuario();
        usuario.setLogin(dto.getLogin());
        usuario.setNome(dto.getNome());
        usuario.setSenha(passwordEncoder.encode(dto.getSenha()));
        usuario.setNivelAcesso(dto.getNivelAcesso());    
        usuario.setUrlImagem(dto.getUrlImagem());
        
    	Usuario salvo = usuarioRepository.save(usuario);
		return new UsuarioDTO(salvo);
   }
    
    // Atualizar  
    public UsuarioDTO update(Long id, UsuarioDTO dto) {
    	Usuario usuario = usuarioRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com ID: " + id));
    	
    	usuario.setNome(dto.getNome());
    	usuario.setSenha(dto.getSenha());
    	
    	Usuario atualizado = usuarioRepository.save(usuario);
        return new UsuarioDTO(atualizado);
    } 
    
    // Remover por ID
    public void delete(Long id) {
        if (!usuarioRepository.existsById(id)) {
            throw new EntityNotFoundException("Usuário não encontrado com ID: " + id);
        }
        usuarioRepository.deleteById(id);
    } 
    
    // Verifica login   
    public boolean existsByLogin(String login) {
        return usuarioRepository.existsByLogin(login);
    }
}
