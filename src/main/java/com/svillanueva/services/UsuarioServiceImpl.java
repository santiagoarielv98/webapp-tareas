package com.svillanueva.services;

import com.svillanueva.models.Usuario;
import com.svillanueva.repositories.UsuarioRepository;
import jakarta.inject.Inject;

import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {
    @Inject
    private UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl() {
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        return Optional.ofNullable(usuarioRepository.findByUsername(username))
                .filter(usuario -> usuario.getPassword()
                        .equals(password));

    }
}
