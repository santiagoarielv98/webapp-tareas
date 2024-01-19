package com.svillanueva.repositories;

import com.svillanueva.models.Usuario;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UsuarioRepositoryImpl implements UsuarioRepository{

    private final Connection conn;

    public UsuarioRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Usuario> listar() throws SQLException {
        return null;
    }

    @Override
    public Usuario porId(Long id) throws SQLException {
        return null;
    }

    @Override
    public void guardar(Usuario usuario) throws SQLException {

    }

    @Override
    public void eliminar(Long id) throws SQLException {

    }

    @Override
    public Usuario findByUsername(String username)  {
        Usuario usuario = null;
        try(var stmt = conn.prepareStatement("SELECT * FROM usuarios WHERE username = ?")){
            stmt.setString(1, username);
            var rs = stmt.executeQuery();
            if(rs.next()){
                usuario = new Usuario();
                usuario.setId(rs.getLong("id"));
                usuario.setUsername(rs.getString("username"));
                usuario.setPassword(rs.getString("password"));
                usuario.setEmail(rs.getString("email"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return usuario;
    }
}
