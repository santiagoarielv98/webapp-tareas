package com.curso.configs;

import jakarta.annotation.Resource;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@ApplicationScoped
public class ProducerResources {

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
        System.out.println("Connection closed");
    }
}
