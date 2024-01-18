package com.svillanueva.tarea9.repositories;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    List<T> listar();

    T porId(Long id);

    List<T> porNombre(String nombre);

    void eliminar(Long id);

    void guardar(T t);
}
