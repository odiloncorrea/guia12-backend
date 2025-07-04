package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.TipoDTO;
import com.cefet.ds_guia12.entity.Tipo;
import com.cefet.ds_guia12.repositories.TipoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class TipoService {

	@Autowired
    private TipoRepository tipoRepository;
    
    public TipoService() {
    } 
    
	// Listar
	public List<TipoDTO> findAll() {
		List<Tipo> lista = tipoRepository.findAll();
		return lista.stream().map(TipoDTO::new).toList();
	}
	
 	// Buscar por ID
    public TipoDTO findById(Long id) {
    	Tipo tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
        return new TipoDTO(tipo);
    }
    
    // Inserir 
    public TipoDTO insert(TipoDTO dto) {        
    	Tipo tipo = new Tipo();
    	tipo.setDescricao(dto.getDescricao());
    	Tipo salvo = tipoRepository.save(tipo);
        return new TipoDTO(salvo);
    }    
    
    // Atualizar  
    public TipoDTO update(Long id, TipoDTO dto) {
    	Tipo tipo = tipoRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Tipo não encontrado com ID: " + id));
    	tipo.setDescricao(dto.getDescricao());
    	Tipo atualizado = tipoRepository.save(tipo);
        return new TipoDTO(atualizado);
    }
    
    // Remover por ID
    public void delete(Long id) {
        if (!tipoRepository.existsById(id)) {
            throw new EntityNotFoundException("Tipo não encontrado  com ID: " + id);
        }
        tipoRepository.deleteById(id);
    }    

}
