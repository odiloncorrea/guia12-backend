package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.ItemDTO;
import com.cefet.ds_guia12.dto.PedidoDTO;
import com.cefet.ds_guia12.entity.Item;
import com.cefet.ds_guia12.entity.Pedido;
import com.cefet.ds_guia12.entity.Usuario;
import com.cefet.ds_guia12.repositories.ItemRepository;
import com.cefet.ds_guia12.repositories.PedidoRepository;
import com.cefet.ds_guia12.repositories.UsuarioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PedidoServico {

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Autowired
	private ItemRepository itemRepository;
	
	@Autowired
	private ItemServico itemServico;	

	public PedidoServico() {
	}

	// Listar
	public List<PedidoDTO> findAll() {
		List<Pedido> lista = pedidoRepository.findAll();
		return lista.stream().map(PedidoDTO::new).toList();
	}

	// Buscar por ID
	public PedidoDTO findById(Long id) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + id));
		return new PedidoDTO(pedido);
	}

	// Inserir
	public PedidoDTO insert(PedidoDTO dto) {
		Pedido pedido = new Pedido();
		pedido.setData(dto.getData());
		pedido.setValor(dto.getValor());

		// Busca o usuário pelo id fornecido no DTO
		Usuario usuario = usuarioRepository.findById(dto.getUsuario().getId()).orElseThrow(
				() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuario().getId()));
		pedido.setUsuario(usuario);

		Pedido salvo = pedidoRepository.save(pedido);
		return new PedidoDTO(salvo);
	}

	// Atualizar
	public PedidoDTO update(Long id, PedidoDTO dto) {
		Pedido pedido = pedidoRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + id));

		pedido.setData(dto.getData());
		pedido.setValor(dto.getValor());

		// Atualiza o usuário (se necessário)
		Usuario usuario = usuarioRepository.findById(dto.getUsuario().getId()).orElseThrow(
				() -> new EntityNotFoundException("Usuário não encontrado com ID: " + dto.getUsuario().getId()));
		pedido.setUsuario(usuario);

		Pedido atualizado = pedidoRepository.save(pedido);
		return new PedidoDTO(atualizado);
	}

	// Remover por ID
	public void delete(Long id) {
		if (!pedidoRepository.existsById(id)) {
			throw new EntityNotFoundException("Pedido não encontrado  com ID: " + id);
		}
		
		// Busca itens associados ao pedido
		List<Item> itens = itemRepository.findByPedidoId(id);
		
	    // Exclui cada item individualmente
	    for (Item item : itens) {
	    	itemServico.delete(item.getId()); //exclui o item através do serviço
	    }
	    
	    // Exclui o pedido
	    pedidoRepository.deleteById(id);
	}

	// Listar itens
	public List<ItemDTO> findItensByPedidoId(Long pedidoId) {
		// Verifica se o pedido existe
		if (!pedidoRepository.existsById(pedidoId)) {
			throw new EntityNotFoundException("Pedido não encontrado com ID: " + pedidoId);
		}

		// Busca itens associados ao pedido
		List<Item> itens = itemRepository.findByPedidoId(pedidoId);
		return itens.stream().map(ItemDTO::new).toList();
	}

}
