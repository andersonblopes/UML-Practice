package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
