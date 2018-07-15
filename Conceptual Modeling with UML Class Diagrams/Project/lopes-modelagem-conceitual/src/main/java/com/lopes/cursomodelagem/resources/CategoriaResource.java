package com.lopes.cursomodelagem.resources;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.services.CategoriaService;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {

	@Autowired
	private CategoriaService categoriaService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {

		Optional<Categoria> categoria = categoriaService.search(id);

		return categoria.isPresent() ? ResponseEntity.ok().body(categoria) : ResponseEntity.notFound().build();
	}

}