package com.svillanueva.tarea3.services;

import com.svillanueva.models.Categoria;
import com.svillanueva.models.Producto;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class ProductoServiceImpl implements ProductoService {
    @Override
    public List<Producto> listar() {
        Categoria categoria = new Categoria();
        categoria.setNombre("computacion");

        Producto producto = new Producto();
        producto.setNombre("notebook");
        producto.setCategoria(categoria);
        producto.setPrecio(175000);
        producto.setId(1L);


        return Arrays.asList(producto,
                new Producto(2L, "mesa escritorio", "oficina", 100000),
                new Producto(3L, "teclado mecanico", "computacion", 40000));
    }

    @Override
    public Optional<Producto> buscarProducto(String nombre) {
        return listar().stream()
                .filter(p -> p.getNombre() != null && !p.getNombre()
                        .isBlank() && p.getNombre()
                        .contains(nombre))
                .findFirst();
    }

    @Override
    public Optional<Producto> porId(Long id) {
        return listar().stream()
                .filter(p -> p.getId() != null && p.getId()
                        .equals(id))
                .findFirst();
    }

    @Override
    public void guardar(Producto p) {

    }

    @Override
    public void eliminar(Long id) {

    }

    @Override
    public List<Categoria> listarCategorias() {
        return null;
    }

    @Override
    public Optional<Categoria> porIdCategoria(Long id) {
        return Optional.empty();
    }
}