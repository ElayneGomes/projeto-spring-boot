package com.elaynegomes.api.controllers;

import com.elaynegomes.api.dtos.EmpresaDto;
import com.elaynegomes.api.entities.Empresa;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/empresas")
public class EmpresaControllers {

    @PostMapping
    public ResponseEntity<EmpresaDto> cadastrar(@RequestBody EmpresaDto empresaDto) {
        empresaDto.setId(1L);
        return ResponseEntity.ok(empresaDto);
    }

}
