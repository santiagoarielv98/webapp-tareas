package com.svillanueva.tarea9.repositories;

import com.svillanueva.tarea9.models.Curso;

import java.util.List;

public interface Repository<T> {
    List<T> listar();
    List<T> porNombre(String nombre);
}
