package com.example.lab1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDB {
    public static boolean authenticate(String username, String password) {
        // Använd JDBC för att kontrollera inloggningsuppgifter mot databasen
        Connection conn = DBManager.getConnection();
        try ( PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?")) {

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            return rs.next(); // Om en matchande användare hittas, returnera true
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("balalalala");
            return false; // I händelse av ett fel, returnera false
        }
    }

    public static boolean isAdmin(String username) {
        boolean isAdmin = false;

            Connection connection = DBManager.getConnection();
            String sql = "SELECT isAdmin FROM users WHERE username = ?";
            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
                preparedStatement.setString(1, username);
                try (ResultSet resultSet = preparedStatement.executeQuery()) {
                    if (resultSet.next()) {
                        isAdmin = resultSet.getBoolean("isAdmin");
                    }
                }
            }
         catch (SQLException e) {
            e.printStackTrace();
            // Handle any database-related exceptions here
        }

        return isAdmin;
    }
    public static void register(String username, String password,Boolean isAdmin){
        Connection connection = DBManager.getConnection();
        String sql = "insert into Users (username, password, isAdmin) value (?, ?, ?);";
        try (PreparedStatement pr = connection.prepareStatement(sql)){
            pr.setString(1,username);
            pr.setString(2,password);
            pr.setBoolean(3,isAdmin);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}


