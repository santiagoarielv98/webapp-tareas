package com.svillanueva.tarea3.services;

import com.svillanueva.models.Categoria;
import com.svillanueva.models.Producto;

import java.util.*;

public interface ProductoService {

    List<Producto> listar();

    Optional<Producto> buscarProducto(String nombre);

    Optional<Producto> porId(Long id);

    void guardar(Producto p);
    void eliminar(Long id);

    List<Categoria> listarCategorias();
    Optional<Categoria> porIdCategoria(Long id);
}