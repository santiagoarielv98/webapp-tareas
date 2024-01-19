package com.svillanueva.services;

import com.svillanueva.models.Usuario;
import com.svillanueva.repositories.UsuarioRepository;
import com.svillanueva.repositories.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection conn) {
        this.usuarioRepository = new UsuarioRepositoryImpl(conn);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        return Optional.ofNullable(usuarioRepository.findByUsername(username))
                .filter(usuario -> usuario.getPassword()
                        .equals(password));

    }
}
