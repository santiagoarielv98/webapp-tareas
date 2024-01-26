package com.curso.services;

import com.curso.configs.ProductoServicePrincipal;
import com.curso.configs.Service;
import com.curso.interceptors.TransactionalJpa;
import com.curso.models.entities.Categoria;
import com.curso.models.entities.Producto;
import com.curso.repositories.CrudRepository;
import com.curso.repositories.RepositoryJPA;
import jakarta.inject.Inject;

import java.util.List;
import java.util.Optional;


@Service
@ProductoServicePrincipal
@TransactionalJpa
//@Named("productoServiceJdbc")
public class ProductoServiceImpl implements ProductoService {
    @Inject
    @RepositoryJPA
    private CrudRepository<Producto> repositoryJdbc;

    @Inject
    @RepositoryJPA
    private CrudRepository<Categoria> repositoryCategoriaJdbc;


    @Override
    public List<Producto> listar() {
        try {
            return repositoryJdbc.listar();
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Producto> porId(Long id) {
        try {
            return Optional.ofNullable(repositoryJdbc.porId(id));
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());

        }
    }

    @Override
    public void guardar(Producto producto) {
        try {
            repositoryJdbc.guardar(producto);
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public void eliminar(Long id) {
        try {
            repositoryJdbc.eliminar(id);
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public List<Categoria> listarCategoria() {
        try {
            return repositoryCategoriaJdbc.listar();
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        try {
            return Optional.ofNullable(repositoryCategoriaJdbc.porId(id));
        } catch (Exception throwable) {
            throw new ServiceJdbcException(throwable.getMessage(), throwable.getCause());
        }
    }
}
