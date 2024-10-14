package com.eafit.nodo;

import com.eafit.nodo.config.DataBaseConfig;
import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try (Connection connection = DataBaseConfig.getConnection()) {
            System.out.println("Connection to Database established");

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}