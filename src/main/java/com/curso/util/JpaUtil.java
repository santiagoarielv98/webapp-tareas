package com.curso.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class JpaUtil {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY = buildEntityManagerFactory();

    private static EntityManagerFactory buildEntityManagerFactory() {
            return jakarta.persistence.Persistence.createEntityManagerFactory("ejemplo");
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGER_FACTORY.createEntityManager();
    }
}
