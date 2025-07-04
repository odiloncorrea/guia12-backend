package com.cefet.ds_guia12.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cefet.ds_guia12.dto.ItemDTO;
import com.cefet.ds_guia12.entity.Item;
import com.cefet.ds_guia12.entity.Pedido;
import com.cefet.ds_guia12.entity.Produto;
import com.cefet.ds_guia12.repositories.ItemRepository;
import com.cefet.ds_guia12.repositories.PedidoRepository;
import com.cefet.ds_guia12.repositories.ProdutoRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class ItemServico {

	@Autowired
    private ItemRepository itemRepository;
	
	@Autowired
    private PedidoRepository pedidoRepository;	
	
	@Autowired
    private ProdutoRepository produtoRepository;	
	
	public ItemServico() {
	}

	// Listar
	public List<ItemDTO> findAll() {
		List<Item> lista = itemRepository.findAll();
		return lista.stream().map(ItemDTO::new).toList();
	}	
	
	// Buscar por ID
	public ItemDTO findById(Long id) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " + id));
		return new ItemDTO(item);
	}	
	
	// Inserir
	public ItemDTO insert(ItemDTO dto) {
		Item item = new Item();
		item.setValor(dto.getValor());
		item.setQuantidade(dto.getQuantidade());
		
        // Busca o pedido pelo id fornecido no DTO
        Pedido pedido = pedidoRepository.findById(dto.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + dto.getIdPedido()));
        
        // Busca o produto pelo id fornecido no DTO
        Produto produto = produtoRepository.findById(dto.getProduto().getId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getProduto().getId()));
        
        // Atualiza o estoque do produto
        produto.setEstoque(produto.getEstoque() - dto.getQuantidade());
        produtoRepository.save(produto); // salva alteração do estoque
        
        item.setPedido(pedido);
		item.setProduto(produto);
		
		Item salvo = itemRepository.save(item);
		return new ItemDTO(salvo);
	}
	
	// Atualizar
	public ItemDTO update(Long id, ItemDTO dto) {
		Item item = itemRepository.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " + id));
				
        // Busca o pedido pelo id fornecido no DTO
        Pedido pedido = pedidoRepository.findById(dto.getIdPedido())
                .orElseThrow(() -> new EntityNotFoundException("Pedido não encontrado com ID: " + dto.getIdPedido()));
        
        // Busca o produto pelo id fornecido no DTO
        Produto produto = produtoRepository.findById(dto.getProduto().getId())
                .orElseThrow(() -> new EntityNotFoundException("Produto não encontrado com ID: " + dto.getProduto().getId()));	
		
        int quantidadeAntiga = item.getQuantidade();
        int quantidadeNova = dto.getQuantidade();
        
        // 	Atualiza o estoque se a quantidade for diferente
        if (quantidadeNova != quantidadeAntiga) {
            // Devolve a quantidade antiga no estoque
            produto.setEstoque(produto.getEstoque() + quantidadeAntiga);

            // Subtrai a nova quantidade
            produto.setEstoque(produto.getEstoque() - quantidadeNova);

            // Salva alteração no estoque
            produtoRepository.save(produto);
        }        
        
        // Atualiza os dados do item
		item.setValor(dto.getValor());
		item.setQuantidade(dto.getQuantidade());
        item.setPedido(pedido);
		item.setProduto(produto);		
		
		Item atualizado = itemRepository.save(item);
		return new ItemDTO(atualizado);
	}
	
	// Remover por ID
	public void delete(Long id) {
	    // Busca o item para acessar sua quantidade e produto
	    Item item = itemRepository.findById(id)
	            .orElseThrow(() -> new EntityNotFoundException("Item não encontrado com ID: " + id));

	    Produto produto = item.getProduto();

	    // Atualiza o estoque somando a quantidade do item de volta
	    produto.setEstoque(produto.getEstoque() + item.getQuantidade());
	    produtoRepository.save(produto); // salva alteração do estoque

	    // Exclui o item
	    itemRepository.deleteById(id);
	}
	
}
