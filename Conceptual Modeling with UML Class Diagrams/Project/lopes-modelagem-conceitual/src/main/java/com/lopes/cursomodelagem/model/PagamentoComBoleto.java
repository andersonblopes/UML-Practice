package com.lopes.cursomodelagem.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;

import com.lopes.cursomodelagem.model.enums.EstadoPagamento;

@Entity
public class PagamentoComBoleto extends Pagamento {

	private static final long serialVersionUID = 1L;

	private LocalDateTime dataVencimento;
	private LocalDateTime dataPagamento;

	public PagamentoComBoleto() {

	}

	public PagamentoComBoleto(EstadoPagamento estadoPagamento, Pedido pedido, LocalDateTime dataVencimento,
			LocalDateTime dataPagamento) {
		super(estadoPagamento, pedido);
		this.dataVencimento = dataVencimento;
		this.dataPagamento = dataPagamento;
	}

	public LocalDateTime getDataVencimento() {
		return dataVencimento;
	}

	public void setDataVencimento(LocalDateTime dataVencimento) {
		this.dataVencimento = dataVencimento;
	}

	public LocalDateTime getDataPagamento() {
		return dataPagamento;
	}

	public void setDataPagamento(LocalDateTime dataPagamento) {
		this.dataPagamento = dataPagamento;
	}

}
