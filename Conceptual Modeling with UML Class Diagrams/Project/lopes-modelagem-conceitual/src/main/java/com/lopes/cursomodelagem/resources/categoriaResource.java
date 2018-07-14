package com.lopes.cursomodelagem.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lopes.cursomodelagem.model.Categoria;

@RestController
@RequestMapping(value = "/categorias")
public class categoriaResource {

	@GetMapping
	public List<Categoria> lista() {
		Categoria c1 = new Categoria(1L, "Computador");
		Categoria c2 = new Categoria(2L, "Celular");

		List<Categoria> lista = new ArrayList<>();
		lista.add(c1);
		lista.add(c2);

		return lista;
	}

}
