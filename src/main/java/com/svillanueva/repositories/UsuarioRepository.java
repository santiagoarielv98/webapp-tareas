package com.svillanueva.repositories;

import com.svillanueva.models.Usuario;

public interface UsuarioRepository extends Repository<Usuario> {
    Usuario findByUsername(String username);

}
