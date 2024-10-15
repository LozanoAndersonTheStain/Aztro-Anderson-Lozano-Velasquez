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
            if (connection != null && connection.isValid(2)) {
                System.out.println("Connection to Database established");
            } else {
                System.out.println("Failed to establish connection to Database");
            }
        } catch (SQLException e) {
            if (e.getSQLState().equals("08001")) {
                System.out.println("Database is not exist: " + dotenv.get("DB_URL"));
            } else {
                System.out.println("Error: " + e.getMessage());
            }
        }
        return connection;
    }
}
