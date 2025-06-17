package com.example.demo.controllers.rest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Test {


        public static void main(String[] args) {
            String url = "jdbc:postgresql://localhost:5432/user_app";
            String user = "postgres";
            String password = "postgres";

            try (Connection connection = DriverManager.getConnection(url, user, password)) {
                System.out.println("Connection successful!");
            } catch (SQLException e) {
                System.err.println("Connection failed: " + e.getMessage());
            }
        }
    
}
