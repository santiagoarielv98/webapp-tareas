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

    @Override
    public void eliminar(Long id) {
        try (PreparedStatement preparedStatement = conn.prepareStatement("DELETE FROM cursos WHERE id=?")) {
            preparedStatement.setLong(1, id);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void guardar(Curso curso) {
        String sql;
        boolean isNew = curso.getId() == null || curso.getId() <= 0;

        if (isNew) {
            sql = "INSERT INTO cursos(nombre, descripcion, instructor, duracion) values(?, ?, ?, ?)";
        } else {
            sql = "UPDATE cursos SET nombre=?, descripcion=?, instructor=?, duracion=? WHERE id=?";
        }
        try (PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setString(1, curso.getNombre());
            preparedStatement.setString(2, curso.getDescripcion());
            preparedStatement.setString(3, curso.getInstructor());
            preparedStatement.setDouble(4, curso.getDuracion());
            if (!isNew) {
                preparedStatement.setLong(5, curso.getId());
            }
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Curso porId(Long id) {
        Curso curso = null;
        try (PreparedStatement prepareStatement = conn.prepareStatement("SELECT * FROM cursos WHERE id=?")
        ) {
            prepareStatement.setLong(1, id);
            try (ResultSet resultSet = prepareStatement.executeQuery()) {
                if (resultSet.next()) {
                    curso = getCurso(resultSet);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return curso;
    }
}
