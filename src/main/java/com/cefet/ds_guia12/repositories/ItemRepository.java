package com.cefet.ds_guia12.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.ds_guia12.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long>{
	List<Item> findByPedidoId(Long pedidoId);
}
