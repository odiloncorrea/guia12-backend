package com.cefet.ds_guia12.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cefet.ds_guia12.dto.ProdutoDTO;
import com.cefet.ds_guia12.services.ProdutoService;



@RestController
@RequestMapping("/produtos")
public class ProdutoController {
	@Autowired
	private ProdutoService produtoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<ProdutoDTO> findById(@PathVariable Long id) {
		ProdutoDTO dto = produtoService.findById(id);
		return ResponseEntity.ok(dto);
	}	
	
	@GetMapping
	public ResponseEntity<List<ProdutoDTO>> findAll() {
		List<ProdutoDTO> dtos = produtoService.findAll();
		return ResponseEntity.ok(dtos);
	}
	
	@PostMapping
	public ResponseEntity<ProdutoDTO> create(@RequestBody ProdutoDTO dto) {
		ProdutoDTO novoDTO = produtoService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<ProdutoDTO> update(@PathVariable Long id, @RequestBody ProdutoDTO dto) {
		ProdutoDTO salvoDTO = produtoService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		produtoService.delete(id);
		return ResponseEntity.noContent().build(); 
	}	
}
