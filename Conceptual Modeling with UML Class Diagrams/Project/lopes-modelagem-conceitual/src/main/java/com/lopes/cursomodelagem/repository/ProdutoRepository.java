package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long> {

}
