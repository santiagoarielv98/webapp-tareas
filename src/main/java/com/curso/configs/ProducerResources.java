package com.curso.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.PersistenceUnit;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;


@ApplicationScoped
public class ProducerResources {
    @Inject
    private Logger logger;


    @Resource(lookup = "java:/MySqlDS")
    private DataSource ds;

    @PersistenceUnit(name = "ejemplo")
    private EntityManagerFactory emf;

    @Produces
    @RequestScoped
    @MySqlConn
    private Connection beanConnection() throws SQLException {
        return ds.getConnection();
    }

    public void closeConnection(@Disposes @MySqlConn Connection conn) throws SQLException {
        conn.close();
        logger.info("Connection closed");
    }

    @Produces
    private Logger logger(InjectionPoint ip) {
        return Logger.getLogger(ip.getMember()
                .getDeclaringClass()
                .getName());
    }

    @Produces
    @RequestScoped
    private EntityManager beanEntityManager() {
        return emf.createEntityManager();
    }

    public void closeEntityManager(@Disposes EntityManager em) {
        if (em.isOpen()) {
            em.close();
        }
    }
}
