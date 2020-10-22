package com.elaynegomes.api;

import com.elaynegomes.api.utils.SenhaUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ProjetoSpringBootApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qrdPorPagina;

	public static void main(String[] args) {
		SpringApplication.run(ProjetoSpringBootApplication.class, args);
		System.out.println("Iniciando Projeto Spring Boot");
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
//		return args -> {
//			System.out.println("### Quantidade de elementos por página: " + this.qrdPorPagina);
//		};

		return args -> {
			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha Encoded: " + senhaEncoded);

			senhaEncoded = SenhaUtils.geraBCrypt("123456");
			System.out.println("Senha encoded novamente: " + senhaEncoded);

			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
		};
	}

}
