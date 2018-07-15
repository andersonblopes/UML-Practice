package com.lopes.cursomodelagem;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.lopes.cursomodelagem.model.Categoria;
import com.lopes.cursomodelagem.repository.CategoriaRepository;

@SpringBootApplication
public class LopesModelagemConceitualApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository repository;

	public static void main(String[] args) {
		SpringApplication.run(LopesModelagemConceitualApplication.class, args);
	}

	// Includes data in database
	@Override
	public void run(String... args) throws Exception {

		Categoria cat1 = new Categoria(null, "Descartáveis");
		Categoria cat2 = new Categoria(null, "Combustíveis");

		repository.saveAll(Arrays.asList(cat1, cat2));

	}
}
