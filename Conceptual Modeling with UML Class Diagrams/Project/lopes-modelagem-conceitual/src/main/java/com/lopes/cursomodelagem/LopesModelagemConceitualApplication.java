package com.lopes.cursomodelagem;

import java.math.BigDecimal;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.model.Produto;
import com.lopes.cursomodelagem.repository.CategoriaRepository;
import com.lopes.cursomodelagem.repository.ProdutoRepository;

@SpringBootApplication
public class LopesModelagemConceitualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	public static void main(String[] args) {
		SpringApplication.run(LopesModelagemConceitualApplication.class, args);
	}

	// Includes data in database
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Descartáveis");
		Categoria cat2 = new Categoria(null, "Combustíveis");

		Produto p1 = new Produto(null, "Guardanapo de papel", new BigDecimal("20.00"));
		Produto p2 = new Produto(null, "Gasolina", new BigDecimal("2000.00"));

		cat1.getProdutos().addAll(Arrays.asList(p1, p2));
		cat2.getProdutos().addAll(Arrays.asList(p1));

		p1.getCategorias().addAll(Arrays.asList(cat1, cat2));
		p2.getCategorias().addAll(Arrays.asList(cat1));

		categoriaRepository.saveAll(Arrays.asList(cat1, cat2));
		produtoRepository.saveAll(Arrays.asList(p1, p2));

	}
}
