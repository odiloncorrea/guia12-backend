package com.cefet.ds_guia12.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cefet.ds_guia12.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
