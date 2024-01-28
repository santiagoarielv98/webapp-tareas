package com.curso.repositories;

import com.curso.configs.Repository;
import com.curso.models.entities.Categoria;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;

import java.util.List;


@RepositoryJPA
@Repository
public class CategoriaRepositoryJPAImpl implements CrudRepository<Categoria> {
    @Inject
    private EntityManager em;

    @Override
    public List<Categoria> listar() throws Exception {
        return em.createQuery("select c from Categoria c", Categoria.class)
                .getResultList();
    }

    @Override
    public Categoria porId(Long id) throws Exception {
        return em.find(Categoria.class, id);
    }

    @Override
    public void guardar(Categoria categoria) throws Exception {
        if (categoria.getId() == null) {
            em.persist(categoria);
        } else {
            em.merge(categoria);
        }
    }

    @Override
    public void eliminar(Long id) throws Exception {
        Categoria categoria = em.find(Categoria.class, id);
        em.remove(categoria);
    }
}
