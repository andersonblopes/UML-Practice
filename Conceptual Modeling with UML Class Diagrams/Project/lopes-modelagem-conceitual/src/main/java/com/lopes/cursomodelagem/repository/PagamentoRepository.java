package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Pagamento;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {

}
