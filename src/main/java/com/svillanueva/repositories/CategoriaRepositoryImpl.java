package com.svillanueva.repositories;

import com.svillanueva.models.Categoria;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoriaRepositoryImpl implements Repository<Categoria> {

    private final Connection conn;

    public CategoriaRepositoryImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Categoria> listar() throws SQLException {
        List<Categoria> listaCategorias = new ArrayList<>();

        try (
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM categorias")
        ) {
            while (resultSet.next()) {
                Categoria c = getCategoria(resultSet);
                listaCategorias.add(c);
            }
        }
        return listaCategorias;
    }


    @Override
    public Categoria porId(Long id) throws SQLException {
        Categoria c = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT * FROM categorias WHERE p.id = ?"
        )
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                        c = getCategoria(resultSet);
                }
            }
        }
        return c;
    }

    private static Categoria getCategoria(ResultSet resultSet) throws SQLException {
        Categoria c = new Categoria();
        c.setId(resultSet.getLong("id"));
        c.setNombre(resultSet.getString("nombre"));
        return c;
    }

    @Override
    public void guardar(Categoria categoria) throws SQLException {
        String sql;
        boolean isUpdate = categoria.getId() != null && categoria.getId() > 0;

        if (isUpdate) {
            sql = " UPDATE categorias SET nombre=? where id=?";

        } else {
            sql = "INSERT INTO categorias (nombre) VALUES(?)";
        }

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, categoria.getNombre());
            if (isUpdate) {
                preparedStatement.setLong(5, categoria.getId());
            }

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM categorias WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }
    }
}
