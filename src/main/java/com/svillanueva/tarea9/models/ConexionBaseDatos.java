package com.svillanueva.tarea9.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBaseDatos {
    public static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=UTC";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
