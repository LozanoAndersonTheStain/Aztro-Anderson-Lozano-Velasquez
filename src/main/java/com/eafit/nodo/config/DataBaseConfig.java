package com.eafit.nodo.config;

import io.github.cdimascio.dotenv.Dotenv;

import java.sql.*;

public class DataBaseConfig {
    private static final Dotenv dotenv = Dotenv.configure().load();

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(
                    dotenv.get("DB_URL"),
                    dotenv.get("DB_USER"),
                    dotenv.get("DB_PASSWORD")
            );
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
