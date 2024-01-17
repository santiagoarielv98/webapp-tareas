package com.svillanueva.tarea9.repositories;

import com.svillanueva.tarea9.models.Curso;

import java.util.List;

public interface Repository<T> {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
