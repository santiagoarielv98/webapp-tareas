package com.svillanueva.repositories;

import com.svillanueva.models.Categoria;
import com.svillanueva.models.Producto;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductoRepositoryJdbcImpl implements Repository<Producto> {
    private final Connection conn;

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

    public static Producto getProducto(ResultSet resultSet) throws SQLException {
        Producto p = new Producto();
        p.setId(resultSet.getLong("id"));
        p.setNombre(resultSet.getString("nombre"));
        p.setPrecio(resultSet.getInt("precio"));
        p.setSku(resultSet.getString("sku"));
        p.setFechaRegistro(resultSet.getDate("fecha_registro")
                .toLocalDate());
        Categoria c = new Categoria();
        c.setId(resultSet.getLong("categoria_id"));
        c.setNombre(resultSet.getString("categoria"));
        p.setCategoria(c);

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
        String sql;
        boolean isUpdate = producto.getId() != null && producto.getId() > 0;

        if (isUpdate) {
            sql = " UPDATE productos SET nombre=?, precio=?, sku=?, categoria_id=? where id=?";

        } else {
            sql = "INSERT INTO productos (nombre, precio, sku, categoria_id, fecha_registro)" +
                    "VALUES(?,?,?,?,?)";
        }

        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, producto.getNombre());
            preparedStatement.setInt(2, producto.getPrecio());
            preparedStatement.setString(3, producto.getSku());
            preparedStatement.setLong(4, producto.getCategoria()
                    .getId());
            if (isUpdate) {
                preparedStatement.setLong(5, producto.getId());
            } else {
                preparedStatement.setDate(5, Date.valueOf(producto.getFechaRegistro()));
            }

            preparedStatement.executeUpdate();
        }

    }

    @Override
    public void eliminar(Long id) throws SQLException {
        String sql = "DELETE FROM productos WHERE id=?";
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        }

    }
}
