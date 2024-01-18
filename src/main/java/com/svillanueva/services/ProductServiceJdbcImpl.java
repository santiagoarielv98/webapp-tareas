package com.svillanueva.services;

import com.svillanueva.models.Categoria;
import com.svillanueva.models.Producto;
import com.svillanueva.repositories.CategoriaRepositoryImpl;
import com.svillanueva.repositories.ProductoRepositoryJdbcImpl;
import com.svillanueva.repositories.Repository;
import com.svillanueva.tarea3.services.ProductoService;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public class ProductServiceJdbcImpl implements ProductoService {
    private final Repository<Producto> productoRepository;

    private final Repository<Categoria> categoriaRepository;

    public ProductServiceJdbcImpl(Connection connection) {
        this.productoRepository = new ProductoRepositoryJdbcImpl(connection);
        this.categoriaRepository = new CategoriaRepositoryImpl(connection);
    }

    @Override
    public List<Producto> listar() {
        try {
            return productoRepository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(productoRepository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void guardar(Producto p) {
        try {
            productoRepository.guardar(p);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            productoRepository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }

    }

    @Override
    public List<Categoria> listarCategorias() {
        try {
            return categoriaRepository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(categoriaRepository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }
}
