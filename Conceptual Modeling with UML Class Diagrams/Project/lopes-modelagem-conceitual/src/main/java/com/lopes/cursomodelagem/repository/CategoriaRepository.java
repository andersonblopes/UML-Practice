package com.lopes.cursomodelagem.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lopes.cursomodelagem.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
