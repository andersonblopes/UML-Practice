package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long> {

}
