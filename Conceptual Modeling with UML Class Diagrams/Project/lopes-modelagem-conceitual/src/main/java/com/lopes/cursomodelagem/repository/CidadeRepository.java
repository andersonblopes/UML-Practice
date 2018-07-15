package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Cidade;

public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
