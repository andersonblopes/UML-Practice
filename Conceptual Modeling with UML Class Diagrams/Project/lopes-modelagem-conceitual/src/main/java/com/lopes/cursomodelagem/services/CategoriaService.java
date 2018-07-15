package com.lopes.cursomodelagem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.cursomodelagem.exceptions.ObjectNotFoundException;
import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.repository.CategoriaRepository;

@Service
public class CategoriaService {

	@Autowired
	private CategoriaRepository categoriaRepository;

	public Categoria search(Long id) {
		Optional<Categoria> categoria = categoriaRepository.findById(id);
		return categoria.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Class: " + Categoria.class.getName()));
	}

}
