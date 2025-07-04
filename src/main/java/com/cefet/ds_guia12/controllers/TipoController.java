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

import com.cefet.ds_guia12.dto.TipoDTO;
import com.cefet.ds_guia12.services.TipoService;

@RestController
@RequestMapping("/tipos")
public class TipoController {

	@Autowired
	private TipoService tipoService;
	
	@GetMapping("/{id}")
	public ResponseEntity<TipoDTO> findById(@PathVariable Long id) {
		TipoDTO dto = tipoService.findById(id);
		return ResponseEntity.ok(dto);
	}	
	
	@GetMapping
	public ResponseEntity<List<TipoDTO>> findAll() {
		List<TipoDTO> dtos = tipoService.findAll();
		return ResponseEntity.ok(dtos);
	}
	
	@PostMapping
	public ResponseEntity<TipoDTO> create(@RequestBody TipoDTO dto) {
		
		TipoDTO novoDTO = tipoService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<TipoDTO> update(@PathVariable Long id, @RequestBody TipoDTO dto) {
		TipoDTO salvoDTO = tipoService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		tipoService.delete(id);
		return ResponseEntity.noContent().build(); 
	}
}
