package com.curso.services;

import com.curso.models.Usuario;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password);

    Optional<Usuario> porUsername(String username) throws SQLException;

    void guardar(Usuario usuario);

    void eliminar(Long id);

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

}
