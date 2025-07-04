package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.ProdutoDTO;
import com.cefet.ds_guia12.entity.Produto;
import com.cefet.ds_guia12.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ProdutoService {
	
	@Autowired
    private ProdutoRepository produtoRepository;
    
    public ProdutoService() {
    } 
    
    // Listar
 	public List<ProdutoDTO> findAll() {
 		List<Produto> lista = produtoRepository.findAll();
 		return lista.stream().map(ProdutoDTO::new).toList();
 	}
 	
  	// Buscar por ID
     public ProdutoDTO findById(Long id) {
    	 Produto produto = produtoRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
         return new ProdutoDTO(produto);
     }
     
     // Inserir 
     public ProdutoDTO insert(ProdutoDTO dto) {        
    	 Produto produto = new Produto();
    	 produto.setDescricao(dto.getDescricao());
    	 produto.setValor(dto.getValor());
    	 produto.setEstoque(dto.getEstoque());
    	 produto.setTipo(dto.getTipo());
     	Produto salvo = produtoRepository.save(produto);
         return new ProdutoDTO(salvo);
     }    
     
     // Atualizar  
     public ProdutoDTO update(Long id, ProdutoDTO dto) {
    	 Produto produto = produtoRepository.findById(id)
                 .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + id));
    	 produto.setDescricao(dto.getDescricao());
    	 produto.setValor(dto.getValor());
    	 produto.setEstoque(dto.getEstoque());
    	 produto.setTipo(dto.getTipo());
     	Produto atualizado = produtoRepository.save(produto);
         return new ProdutoDTO(atualizado);
     }
     
     // Remover por ID
     public void delete(Long id) {
         if (!produtoRepository.existsById(id)) {
             throw new EntityNotFoundException("Produto não encontrado  com ID: " + id);
         }
         produtoRepository.deleteById(id);
     }    
    

}
