package com.svillanueva.services;

import com.svillanueva.models.Usuario;

import java.sql.SQLException;
import java.util.Optional;

public interface UsuarioService {
    Optional<Usuario> login(String username, String password) throws SQLException;
}
