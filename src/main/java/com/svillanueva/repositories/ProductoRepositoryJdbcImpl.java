package com.svillanueva.repositories;

import com.svillanueva.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {
    private Connection conn;

    public ProductoRepositoryJdbcImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Producto> listar() throws SQLException {
        List<Producto> productos = new ArrayList<>();

        try (Statement statement = conn.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT p.*, c.nombre as categoria FROM productos as p INNER JOIN categorias as c ON p.categoria_id = c.id")
        ) {
            while (resultSet.next()) {
                Producto p = getProducto(resultSet);

                productos.add(p);
            }
        }
        return productos;
    }

    private static Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setTipo(resultSet.getString("categoria"));
        return p;
    }

    @Override
    public Producto porId(Long id) throws SQLException {
        Producto p = null;
        try (PreparedStatement preparedStatement = conn.prepareStatement(
                "SELECT p.*, c.nombre as categoria FROM productos as p INNER JOIN categorias as c ON p.categoria_id = c.id WHERE p.id = ?"
        )
        ) {
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    p = getProducto(resultSet);
                }
            }
        }
        return p;
    }

    @Override
    public void guardar(Producto producto) throws SQLException {

    }

    @Override
    public void eliminar(Integer id) throws SQLException {

    }
}
