package com.curso.services;

import com.curso.models.entities.Categoria;
import com.curso.models.entities.Producto;
import jakarta.ejb.Local;

import java.util.List;
import java.util.Optional;

@Local
public interface ProductoService {
    List<Producto> listar();

    Optional<Producto> porId(Long id);

    void guardar(Producto producto);

    void eliminar(Long id);

    List<Categoria> listarCategoria();

    Optional<Categoria> porIdCategoria(Long id);
}
