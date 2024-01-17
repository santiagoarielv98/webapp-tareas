package com.svillanueva.tarea9.services;

import com.svillanueva.tarea9.models.Curso;

import java.util.List;

public interface CursoService {
    List<Curso> listar();
    List<Curso> porNombre(String nombre);
}
