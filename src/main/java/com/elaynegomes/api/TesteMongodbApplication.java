package com.elaynegomes.api;

import com.elaynegomes.api.documents.Cliente;
import com.elaynegomes.api.repositories.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TesteMongodbApplication {

    @Autowired
    private ClienteRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(TesteMongodbApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner() {
      return args -> {
          repository.deleteAll();

          repository.save(new Cliente("Alice", 20));
          repository.save(new Cliente("João", 30));
          repository.save(new Cliente("Maria", 40));

          System.out.println("Lista todos com o findAll(): ");
          System.out.println("------------------------------");
          repository.findAll().forEach(System.out::println);
          System.out.println();

          System.out.println("Busca um único cliente com o findByNome('Alice'): ");
          System.out.println("--------------------------------------------------");
          System.out.println(repository.findByNome("Alice"));
          System.out.println();

          System.out.println("Clientes com idade entre 18 e 35 anos: ");
          System.out.println("---------------------------------------");
          repository.findByIdadeBetween(18,35).forEach(System.out::println);

      };
    }

}
