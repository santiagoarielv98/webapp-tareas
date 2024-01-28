package com.curso.services;

import com.curso.models.entities.Usuario;
import jakarta.ejb.Local;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Local
public interface UsuarioService {
    Optional<Usuario> login(String username, String password);

    Optional<Usuario> porUsername(String username) throws SQLException;

    void guardar(Usuario usuario);

    void eliminar(Long id);

    List<Usuario> listar();

    Optional<Usuario> porId(Long id);

}
