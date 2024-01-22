package com.curso.configs;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.inject.Named;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProducerResources {

    @Produces
    @RequestScoped
    @Named("conn")
    private Connection beanConnection() throws SQLException {
        Context initContext;
        DataSource ds;
        try {
            initContext = new InitialContext();
            Context envContext = (Context) initContext.lookup("java:/comp/env");
            ds = (DataSource) envContext.lookup("jdbc/TestDB");
        } catch (NamingException e) {
            throw new RuntimeException(e);
        }

        return ds.getConnection();
    }
}
