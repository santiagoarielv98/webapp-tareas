package com.curso.services;

import com.curso.configs.Service;
import com.curso.interceptors.TransactionalJpa;
import com.curso.models.entities.Usuario;
import com.curso.repositories.RepositoryJPA;
import com.curso.repositories.UsuarioRepository;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@Service
@TransactionalJpa
public class UsuarioServiceImpl implements UsuarioService {


    @Inject
    @RepositoryJPA
    private UsuarioRepository usuarioRepository;


    @Override
    public Optional<Usuario> login(String username, String password) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username))
                    .filter(u -> u.getPassword()
                            .equals(password));
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Usuario> porUsername(String username) {
        try {
            return Optional.ofNullable(usuarioRepository.porUsername(username));
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void guardar(Usuario usuario) {
        try {
            usuarioRepository.guardar(usuario);
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            usuarioRepository.eliminar(id);
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Usuario> listar() {
        try {
            return usuarioRepository.listar();
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Usuario> porId(Long id) {
        try {
            return Optional.ofNullable(usuarioRepository.porId(id));
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }
}
