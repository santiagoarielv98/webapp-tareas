package org.aguzman.apiservlet.webapp.jdbc.tarea.services;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.aguzman.apiservlet.webapp.jdbc.tarea.models.Curso;
import org.aguzman.apiservlet.webapp.jdbc.tarea.repositories.Repository;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;
import org.aguzman.apiservlet.webapp.jdbc.tarea.interceptors.TransactionalJdbc;

@ApplicationScoped
public class CursoServiceImpl implements CursoService{
    
    @Inject
    private Repository<Curso> repository;

    @Override
    public List<Curso> listar() {
        try {
            return repository.listar();
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        try {
            return repository.porNombre(nombre);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    public Optional<Curso> porId(Long id) {
        try {
            return Optional.ofNullable(repository.porId(id));
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    @TransactionalJdbc
    public void guardar(Curso curso) {
        try {
            repository.guardar(curso);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

    @Override
    @TransactionalJdbc
    public void eliminar(Long id) {
        try {
            repository.eliminar(id);
        } catch (SQLException e) {
            throw new ServiceJdbcException(e.getMessage(), e.getCause());
        }
    }

}
