package org.example.lab4;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
public class DatabaseUsage {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();

        try {
            Connection connection = dbConnector.getConnection();
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("INSERT INTO Students (id, name,age) VALUES (1, 'John Doe', 20)");
            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}