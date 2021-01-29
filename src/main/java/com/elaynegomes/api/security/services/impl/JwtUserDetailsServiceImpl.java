package com.elaynegomes.api.security.services.impl;


import com.elaynegomes.api.security.JwtUserFactory;
import com.elaynegomes.api.security.entities.Usuario;
import com.elaynegomes.api.security.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UsuarioService usuarioService;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Usuario> funcionario = usuarioService.buscarPorEmail(username);
        if (funcionario.isPresent()) {
            return JwtUserFactory.create(funcionario.get());
        }
        throw new UsernameNotFoundException("Email não encontrado.");
    }
}