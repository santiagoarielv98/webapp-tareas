package com.curso.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Logger;


@ApplicationScoped
public class ProducerResources {
    @Inject
    private Logger logger;


    @Resource(name = "jdbc/TestDB")
    private DataSource ds;

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
}
