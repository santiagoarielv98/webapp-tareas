package com.curso.services;

import com.curso.models.Categoria;
import com.curso.models.Producto;
import com.curso.repositories.Repository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@ApplicationScoped
//@Named("productoServiceJdbc")
public class ProductoServiceJdbcImpl implements ProductoService {
    @Inject
    private Repository<Producto> repositoryJdbc;

    @Inject
    private Repository<Categoria> repositoryCategoriaJdbc;


    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (SQLException throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }
}
