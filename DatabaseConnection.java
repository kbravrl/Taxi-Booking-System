package com.example.taxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static final String url = "jdbc:mysql://localhost:3306/taxi";
    private static final String username = "root";
    private static final String password = "";

    private Connection connection;

    public DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(url, username, password);
            System.out.println("Bağlantı başarılı!");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Bağlantı hatası: " + e.getMessage());
        }
    }

    public Connection getConnection() {
        return connection;
    }

    public void closeConnection() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Bağlantı kapatıldı.");
            } catch (SQLException e) {
                System.out.println("Bağlantı kapatma hatası: " + e.getMessage());
            }
        }
    }
}
