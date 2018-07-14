package com.lopes.cursomodelagem.resources;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/categorias")
public class categoriaResource {

	@GetMapping
	public String iniciar() {
		return "REST OK!";
	}

}
