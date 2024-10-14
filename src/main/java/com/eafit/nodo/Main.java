package com.eafit.nodo;

import io.github.cdimascio.dotenv.Dotenv;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        // Cargar las variables de entorno desde el archivo .env
        Dotenv dotenv = Dotenv.configure().load();

        // Establecer la conexión a la base de datos utilizando try-with-resources
        try (Connection connection = DriverManager.getConnection(
                dotenv.get("DB_URL"),
                dotenv.get("DB_USER"),
                dotenv.get("DB_PASSWORD")
        )) {
            // Imprimir un mensaje si la conexión es exitosa
            System.out.println("Connection to Database established");

        } catch (SQLException e) {
            // Imprimir el mensaje de error si ocurre una excepción
            System.out.println(e.getMessage());
        }
    }
}