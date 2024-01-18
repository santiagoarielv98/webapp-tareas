package com.svillanueva.tarea9.services;

import com.svillanueva.tarea9.models.Curso;

import java.util.List;
import java.util.Optional;

public interface CursoService {
    List<Curso> listar();

    Optional<Curso> porId(Long id);
    List<Curso> porNombre(String nombre);

    void eliminar(Long id);

    void guardar(Curso curso);
}
