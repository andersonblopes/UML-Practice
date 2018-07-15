package com.lopes.cursomodelagem.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lopes.cursomodelagem.model.Cliente;
import com.lopes.cursomodelagem.services.ClienteService;

@RestController
@RequestMapping(value = "/clientes")
public class ClienteResource {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(value = "/{id}")
	public ResponseEntity<?> buscar(@PathVariable Long id) {

		Cliente cliente = clienteService.search(id);

		return ResponseEntity.ok().body(cliente);
	}

}
