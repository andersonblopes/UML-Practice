package com.lopes.cursomodelagem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Optional<Categoria> search(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria;
	}

}
