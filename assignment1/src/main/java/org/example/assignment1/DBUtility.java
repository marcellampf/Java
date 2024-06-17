package org.example.assignment1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DBUtility {
    private static final String URL = "jdbc:mysql://localhost:3306/testdb";
    private static final String USER = "root";
    private static final String PASSWORD = "password here";

    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public static List<Game> getGames() throws Exception {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM games");

        while (rs.next()) {
            games.add(new Game(
                    rs.getString("title"),
                    rs.getString("platform"),
                    rs.getInt("year"),
                    rs.getString("genre"),
                    rs.getString("publisher"),
                    rs.getFloat("sales")
            ));
        }

        rs.close();
        stmt.close();
        conn.close();
        return games;
    }

    public static List<Game> getGamesByYear(int year) throws Exception {
        List<Game> games = new ArrayList<>();
        Connection conn = getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM games WHERE year = " + year);

        while (rs.next()) {
            games.add(new Game(
                    rs.getString("title"),
                    rs.getString("platform"),
                    rs.getInt("year"),
                    rs.getString("genre"),
                    rs.getString("publisher"),
                    rs.getFloat("sales")
            ));
        }

        rs.close();
        stmt.close();
        conn.close();
        return games;
    }
}
