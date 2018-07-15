package com.lopes.cursomodelagem.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lopes.cursomodelagem.exceptions.ObjectNotFoundException;
import com.lopes.cursomodelagem.model.Pedido;
import com.lopes.cursomodelagem.repository.PedidoRepository;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository pedidoRepository;

	public Pedido search(Long id) {
		Optional<Pedido> pedido = pedidoRepository.findById(id);
		return pedido.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + " Class: " + Pedido.class.getName()));
	}

}
