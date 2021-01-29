package com.elaynegomes.api.security.services;

import com.elaynegomes.api.security.entities.Usuario;

import java.util.Optional;

public interface UsuarioService {

    /**
     * Busca e retorna um usuário dado um email.
     *
     * @param email
     * @return Optional<Usuario>
     * */
    Optional<Usuario> buscarPorEmail(String email);
}