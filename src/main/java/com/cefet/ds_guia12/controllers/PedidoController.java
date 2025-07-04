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
import com.cefet.ds_guia12.dto.PedidoDTO;
import com.cefet.ds_guia12.services.PedidoServico;

@RestController
@RequestMapping("/pedidos")
public class PedidoController {
	
	@Autowired
	private PedidoServico pedidoService;	
	
	@GetMapping("/{id}")
	public ResponseEntity<PedidoDTO> findById(@PathVariable Long id) {
		PedidoDTO dto = pedidoService.findById(id);
		return ResponseEntity.ok(dto);
	}	
	
	@GetMapping
	public ResponseEntity<List<PedidoDTO>> findAll() {
		List<PedidoDTO> dtos = pedidoService.findAll();
		return ResponseEntity.ok(dtos);
	}	
	
	@PostMapping
	public ResponseEntity<PedidoDTO> create(@RequestBody PedidoDTO dto) {
		PedidoDTO novoDTO = pedidoService.insert(dto);
		return ResponseEntity.status(201).body(novoDTO); 
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<PedidoDTO> update(@PathVariable Long id, @RequestBody PedidoDTO dto) {
		PedidoDTO salvoDTO = pedidoService.update(id, dto);
		return ResponseEntity.ok(salvoDTO); 
	}	
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		pedidoService.delete(id);
		return ResponseEntity.noContent().build(); 
	}	
	
	@GetMapping("/{id}/itens")
	public ResponseEntity<List<ItemDTO>> findItensByPedidoId(@PathVariable Long id) {
	    List<ItemDTO> itens = pedidoService.findItensByPedidoId(id);
	    return ResponseEntity.ok(itens);
	}	

}
