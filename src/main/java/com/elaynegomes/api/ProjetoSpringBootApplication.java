package com.elaynegomes.api;

import com.elaynegomes.api.repositories.EmpresaRepository;
import com.elaynegomes.api.services.ExemploService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class ProjetoSpringBootApplication {

	@Value("${paginacao.qtd_por_pagina}")
	private int qrdPorPagina;

	@Autowired
	private EmpresaRepository empresaRepository;

	@Autowired
	private ExemploService exemploService;

	public static void main(String[] args) {
		System.out.println("Iniciando Projeto Spring Boot");
		SpringApplication.run(ProjetoSpringBootApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			this.exemploService.testarServico();
		};

//		return args -> {
//			Empresa empresa = new Empresa();
//			empresa.setRazaoSocial("Empresa Teste");
//			empresa.setCnpj("12345678934567");
//
//			this.empresaRepository.save(empresa);
//
//			List<Empresa> empresas = empresaRepository.findAll();
//			empresas.forEach(System.out::println);
//
////			Empresa empresaDb = empresaRepository.getOne(1L);
////			System.out.println("Empresa por ID: " + empresaDb);
////
////			empresaDb.setRazaoSocial("Empresa Teste Web");
////			this.empresaRepository.save(empresaDb);
//
//			Empresa empresaCnpj = empresaRepository.findByCnpj("12345678934567");
//			System.out.println("Empresa por CNPJ: " + empresaCnpj);
//
//			this.empresaRepository.deleteById(1L);
//			empresas = empresaRepository.findAll();
//			System.out.println("Empresas: " + empresas.size());
//
//
//		};

//		return args -> {
//			System.out.println("### Quantidade de elementos por página: " + this.qrdPorPagina);
//		};

//		return args -> {
//			String senhaEncoded = SenhaUtils.geraBCrypt("123456");
//			System.out.println("Senha Encoded: " + senhaEncoded);
//
//			senhaEncoded = SenhaUtils.geraBCrypt("123456");
//			System.out.println("Senha encoded novamente: " + senhaEncoded);
//
//			System.out.println("Senha válida: " + SenhaUtils.senhaValida("123456", senhaEncoded));
//		};

	}

}
