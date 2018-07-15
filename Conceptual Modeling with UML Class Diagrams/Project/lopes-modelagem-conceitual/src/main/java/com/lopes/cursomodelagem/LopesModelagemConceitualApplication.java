package com.lopes.cursomodelagem;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.model.Cidade;
import com.lopes.cursomodelagem.model.Estado;
import com.lopes.cursomodelagem.model.Produto;
import com.lopes.cursomodelagem.repository.CategoriaRepository;
import com.lopes.cursomodelagem.repository.CidadeRepository;
import com.lopes.cursomodelagem.repository.EstadoRepository;
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

	public static void main(String[] args) {
		SpringApplication.run(LopesModelagemConceitualApplication.class, args);
	}

	// Includes data in database
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria("Descartáveis");
		Categoria cat2 = new Categoria("Combustíveis");

		Produto p1 = new Produto("Guardanapo de papel", new BigDecimal("20.00"));
		Produto p2 = new Produto("Gasolina", new BigDecimal("2000.00"));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p1));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2));

		Estado est1 = new Estado("Ceará", "CE");
		Estado est2 = new Estado("Rio Grande do Norte", "RN");

		Cidade cid1 = new Cidade("Fortakeza", est1);
		Cidade cid2 = new Cidade("Caucaia", est1);
		Cidade cid3 = new Cidade("Mossoró", est2);

		estadoRepository.saveAll(Arrays.asList(est1, est2));
		cidadeRepository.saveAll(Arrays.asList(cid1, cid2, cid3));

	}
}
