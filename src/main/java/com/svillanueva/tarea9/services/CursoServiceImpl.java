package com.svillanueva.tarea9.services;

import com.svillanueva.tarea9.models.Curso;
import com.svillanueva.tarea9.repositories.CursoRepositorioImpl;
import com.svillanueva.tarea9.repositories.Repository;

import java.sql.Connection;
import java.util.List;

public class CursoServiceImpl implements CursoService {


    private final Repository<Curso> cursoRepository;

    public CursoServiceImpl(Connection conn) {
        this.cursoRepository = new CursoRepositorioImpl(conn);
    }

    @Override
    public List<Curso> listar() {
        return cursoRepository.listar();
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        return cursoRepository.porNombre(nombre);
    }
}
