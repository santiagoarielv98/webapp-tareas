package com.curso.services;

import com.curso.models.Usuario;
import com.curso.repositories.UsuarioRepository;
import com.curso.repositories.UsuarioRepositoryImpl;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(Connection connection) {
        this.usuarioRepository = new UsuarioRepositoryImpl(connection);
    }

    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(u -> u.getPassword()
                            .equals(password));
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Usuario> porUsername(String username) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username));
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void guardar(Usuario usuario) {
        try {
            usuarioRepository.guardar(usuario);
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioRepository.eliminar(id);
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            return usuarioRepository.listar();
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Usuario> porId(Long id) {
        try {
            return Optional.ofNullable(usuarioRepository.porId(id));
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }
}
