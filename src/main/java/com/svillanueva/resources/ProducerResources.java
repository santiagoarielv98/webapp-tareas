package com.svillanueva.resources;

import com.svillanueva.configs.MySqlConn;
import jakarta.annotation.Resource;
import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Disposes;
import jakarta.enterprise.inject.Produces;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class ProducerResources {

    @Resource(name = "jdbc/mysqlDB")
    private DataSource ds;

    @Produces
    @RequestScoped
    @MySqlConn
    private Connection beanConnection() throws SQLException {
        return ds.getConnection();
    }

    public void close(@Disposes @MySqlConn Connection connection) throws SQLException {
        connection.close();
    }
}
