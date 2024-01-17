package com.svillanueva.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    public static final String URL = "jdbc:mysql://localhost:3306/java_curso?serverTimezone=America/Buenos_Aires";
    public static final String USERNAME = "root";
    public static final String PASSWORD = "";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

}
