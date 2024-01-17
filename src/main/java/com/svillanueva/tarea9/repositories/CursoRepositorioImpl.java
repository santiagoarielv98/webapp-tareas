package com.svillanueva.tarea9.repositories;

import com.svillanueva.tarea9.models.Curso;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CursoRepositorioImpl implements Repository<Curso> {
    private final Connection conn;

    public CursoRepositorioImpl(Connection conn) {
        this.conn = conn;
    }

    @Override
    public List<Curso> listar() {
        List<Curso> listaCursos = new ArrayList<>();
        try (
                Statement statement = conn.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM cursos")
        ) {
            while (resultSet.next()) {
                Curso curso = getCurso(resultSet);
                listaCursos.add(curso);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCursos;
    }

    private static Curso getCurso(ResultSet resultSet) throws SQLException {
        Curso curso = new Curso();
        curso.setId(resultSet.getLong("id"));
        curso.setNombre(resultSet.getString("nombre"));
        curso.setDescripcion(resultSet.getString("descripcion"));
        curso.setInstructor(resultSet.getString("instructor"));
        curso.setDuracion(resultSet.getDouble("duracion"));
        return curso;
    }

    @Override
    public List<Curso> porNombre(String nombre) {
        List<Curso> listaCursos = new ArrayList<>();
        try (PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM cursos WHERE nombre like ?")
        ) {
            prepareStatement.setString(1, "%" + nombre + "%");
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                while (resultSet.next()) {
                    Curso curso = getCurso(resultSet);
                    listaCursos.add(curso);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return listaCursos;
    }
}
