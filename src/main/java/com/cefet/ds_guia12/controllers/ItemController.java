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

import com.cefet.ds_guia12.dto.ItemDTO;
import com.cefet.ds_guia12.services.ItemServico;



@RestController
@RequestMapping("/itens")
public class ItemController {

	@Autowired
	private ItemServico itemService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<ItemDTO> findById(@PathVariable Long id) {
		ItemDTO dto = itemService.findById(id);
		return ResponseEntity.ok(dto);
	}
	
	@GetMapping
	public ResponseEntity<List<ItemDTO>> findAll() {
		List<ItemDTO> dtos = itemService.findAll();
		return ResponseEntity.ok(dtos);
	}
	
	@PostMapping
	public ResponseEntity<ItemDTO> create(@RequestBody ItemDTO dto) {
		ItemDTO novoDTO = itemService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}	
	
	@PutMapping("/{id}")
	public ResponseEntity<ItemDTO> update(@PathVariable Long id, @RequestBody ItemDTO dto) {
		ItemDTO salvoDTO = itemService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		itemService.delete(id);
		return ResponseEntity.noContent().build(); 
	}		
}
