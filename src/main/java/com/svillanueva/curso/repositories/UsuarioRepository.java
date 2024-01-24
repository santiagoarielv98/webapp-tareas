package com.svillanueva.curso.repositories;

import com.svillanueva.curso.models.Usuario;

import java.sql.SQLException;

public interface UsuarioRepository extends CrudRepository<Usuario> {
    Usuario porUsername(String username) throws SQLException;
}
