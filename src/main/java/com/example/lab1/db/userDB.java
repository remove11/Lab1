/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.db;

import com.example.lab1.bo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Hämtar och lagrar User i db
 */
public class userDB {

    /**
     * Kollar om användare o lösenord stämmer mot db
     * @param username
     * @param password
     * @return En user som förfrågas
     */
    public static User authenticate(String username, String password) {
        Connection conn = DBManager.getConnection();
        try (PreparedStatement ps = conn.prepareStatement("SELECT * FROM Users WHERE username = ? AND password = ?")) {
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                return User.createUser(rs.getInt("ID"), rs.getString("username"), rs.getString("password"), rs.getBoolean("isAdmin"));
            } else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * Kollar om en user är admin
     * @param username
     * @return true om user är admin
     */
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
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return isAdmin;
    }

    /**
     * Registrerar en ny user i db
     * @param username
     * @param password
     * @param isAdmin
     */
    public static void register(String username, String password, Boolean isAdmin) {
        Connection connection = DBManager.getConnection();
        String sql = "INSERT INTO users (username, password, isAdmin) VALUES (?, ?, ?)";
        try (PreparedStatement pr = connection.prepareStatement(sql)) {
            pr.setString(1, username);
            pr.setString(2, password);
            pr.setBoolean(3, isAdmin);
            pr.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

