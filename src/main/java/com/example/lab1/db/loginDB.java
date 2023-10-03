package com.example.lab1.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDB {
    public boolean authenticate(String username, String password) {
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

    public boolean isAdmin(String username)
    {
        return true;
    }
}


