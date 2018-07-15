package com.lopes.cursomodelagem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.cursomodelagem.exceptions.ObjectNotFoundException;
import com.lopes.cursomodelagem.model.Cliente;
import com.lopes.cursomodelagem.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	public Cliente search(Long id) {
		Optional<Cliente> cliente = clienteRepository.findById(id);
		return cliente.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Class: " + Cliente.class.getName()));
	}

}
