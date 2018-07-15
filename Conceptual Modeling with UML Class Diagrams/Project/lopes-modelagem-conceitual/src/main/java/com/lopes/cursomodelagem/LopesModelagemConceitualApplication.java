package com.lopes.cursomodelagem;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopes.cursomodelagem.model.Bairro;
import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.model.Cidade;
import com.lopes.cursomodelagem.model.Cliente;
import com.lopes.cursomodelagem.model.Endereco;
import com.lopes.cursomodelagem.model.Estado;
import com.lopes.cursomodelagem.model.ItemPedido;
import com.lopes.cursomodelagem.model.Pagamento;
import com.lopes.cursomodelagem.model.PagamentoComBoleto;
import com.lopes.cursomodelagem.model.PagamentoComCartao;
import com.lopes.cursomodelagem.model.Pedido;
import com.lopes.cursomodelagem.model.Produto;
import com.lopes.cursomodelagem.model.enums.EstadoPagamento;
import com.lopes.cursomodelagem.model.enums.TipoCliente;
import com.lopes.cursomodelagem.repository.BairroRepository;
import com.lopes.cursomodelagem.repository.CategoriaRepository;
import com.lopes.cursomodelagem.repository.CidadeRepository;
import com.lopes.cursomodelagem.repository.ClienteRepository;
import com.lopes.cursomodelagem.repository.EnderecoRepository;
import com.lopes.cursomodelagem.repository.EstadoRepository;
import com.lopes.cursomodelagem.repository.ItemPedidoRepository;
import com.lopes.cursomodelagem.repository.PagamentoRepository;
import com.lopes.cursomodelagem.repository.PedidoRepository;
import com.lopes.cursomodelagem.repository.ProdutoRepository;

@SpringBootApplication
public class LopesModelagemConceitualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private BairroRepository bairroRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LopesModelagemConceitualApplication.class, args);
	}

	// Includes data in database
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Diversos");
		Categoria cat2 = new Categoria("Combustíveis");

		Produto p1 = new Produto("Guardanapo de papel", new BigDecimal("20.00"));
		Produto p2 = new Produto("Gasolina", new BigDecimal("2000.00"));
		Produto p3 = new Produto("Álcool", new BigDecimal("100.00"));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
		cat2.getProdutos().addAll(Arrays.asList(p2, p3));

		p1.getCategorias().addAll(Arrays.asList(cat1));
		p2.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p3.getCategorias().addAll(Arrays.asList(cat1, cat2));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

		Estado est1 = new Estado("Ceará", "CE");
		Estado est2 = new Estado("Rio Grande do Norte", "RN");

		Cidade cid1 = new Cidade("Fortakeza", est1);
		Cidade cid2 = new Cidade("Caucaia", est1);
		Cidade cid3 = new Cidade("Mossoró", est2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

		Cliente anderson = new Cliente("Anderson Lopes", "anderson@email.com", "111.111.111-11",
				TipoCliente.PESSOA_FISICA);
		anderson.getTelefones().addAll(Arrays.asList("11111111111", "33333333333"));

		Cliente elaine = new Cliente("Elaine Lopes", "elaine@email.com", "222.222.222-22", TipoCliente.PESSOA_FISICA);
		elaine.getTelefones().addAll(Arrays.asList("222222222222222", "4444444444444"));
		Cliente helena = new Cliente("Helena Lopes", "helena@email.com", "333.333.333-33", TipoCliente.PESSOA_FISICA);
		helena.getTelefones().addAll(Arrays.asList("33333333333333", "555555555555555"));
		Cliente empresa = new Cliente("Empresa Lopes", "empresa@email.com", "41.982.709/0001-17",
				TipoCliente.PESSOA_JURIDICA);
		empresa.getTelefones().addAll(Arrays.asList("44444444444", "666666666666"));

		clienteRepository.saveAll(Arrays.asList(anderson, elaine, helena, empresa));

		Bairro b1 = new Bairro("Lagoa Redonda", cid1);
		Bairro b2 = new Bairro("Araturi", cid2);
		Bairro b3 = new Bairro("Santo Antonio", cid3);

		bairroRepository.saveAll(Arrays.asList(b1, b2, b3));

		Endereco end1 = new Endereco("Rua A", "109", "APTO 101", b1, "60.831-222", anderson);
		Endereco end2 = new Endereco("Rua B", "333", "APTO 10", b2, "60.732.23", elaine);
		Endereco end3 = new Endereco("Rua C", "555", "", b1, "60.732.23", helena);
		Endereco end4 = new Endereco("Rua D", "444", "", b3, "60.732.23", empresa);

		enderecoRepository.saveAll(Arrays.asList(end1, end2, end3, end4));

		Pedido pedido1 = new Pedido(LocalDateTime.of(2016, Month.APRIL, 4, 22, 30), anderson, end1);
		Pedido pedido2 = new Pedido(LocalDateTime.of(2013, Month.DECEMBER, 4, 12, 10), elaine, end2);

		Pagamento pag1 = new PagamentoComCartao(EstadoPagamento.QUITADO, pedido1, 6);
		pedido1.setPagamento(pag1);
		Pagamento pag2 = new PagamentoComBoleto(EstadoPagamento.PENDENTE, pedido2,
				LocalDateTime.of(2014, Month.JANUARY, 4, 12, 10), null);
		pedido2.setPagamento(pag2);

		pedidoRepository.saveAll(Arrays.asList(pedido1, pedido2));
		pagamentoRepository.saveAll(Arrays.asList(pag1, pag2));

		ItemPedido it1 = new ItemPedido(pedido1, p1, new BigDecimal("0.00"), 10, new BigDecimal("200.23"));
		ItemPedido it2 = new ItemPedido(pedido1, p3, new BigDecimal("0.00"), 100, new BigDecimal("80.00"));
		ItemPedido it3 = new ItemPedido(pedido2, p2, new BigDecimal("0.00"), 1, new BigDecimal("40.00"));

		pedido1.getItens().addAll(Arrays.asList(it1, it2));
		pedido2.getItens().addAll(Arrays.asList(it3));

		p1.getItens().addAll(Arrays.asList(it1));
		p2.getItens().addAll(Arrays.asList(it3));
		p3.getItens().addAll(Arrays.asList(it2));

		itemPedidoRepository.saveAll(Arrays.asList(it1, it2, it3));

	}
}
