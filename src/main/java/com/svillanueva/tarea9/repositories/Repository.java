package com.svillanueva.tarea9.repositories;

import java.util.List;

public interface Repository<T> {
    List<T> listar();
    List<T> porNombre(String nombre);
}
