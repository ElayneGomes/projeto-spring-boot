package com.elaynegomes.api.security;

import com.elaynegomes.api.security.entities.Usuario;
import com.elaynegomes.api.security.enums.PerfilEnum;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;

public class JwtUserFactory {

    public JwtUserFactory() {
    }

    /**
     * Converte e gera um JwtUser com base nos dados de um funcionário.
     *
     * @param usuario
     * @return JwtUser
     * */
    public static JwtUser create(Usuario usuario) {
        return new JwtUser(usuario.getId(), usuario.getEmail(), usuario.getSenha(), mapToGrandetAuthorities(usuario.getPerfil()));
    }

    /**
     * Converte o perfil do usuário para o formato utilizado pelo Spring Security.
     *
     * @param perfilEnum
     * @return List<GrantedAuthority>
     * */
    private static List<GrantedAuthority> mapToGrandetAuthorities(PerfilEnum perfilEnum) {
        List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
        authorities.add(new SimpleGrantedAuthority(perfilEnum.toString()));
        return authorities;
    }

}