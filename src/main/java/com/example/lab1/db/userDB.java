package com.example.lab1.db;

import com.example.lab1.bo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 * The `userDB` class provides database operations related to user
 */
public class userDB {

    /**
     * Authenticates a user by checking their username and password in the database.
     * @param username
     * @param password
     * @return A User object representing the authenticated user
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
            System.out.println("An error occurred during login");
            return null;
        }
    }

    /**
     * Checks if a user is an administrator.
     * @param username The username of the user to check.
     * @return true if the user is an administrator, false otherwise.
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
            // Handle any database-related exceptions here
        }

        return isAdmin;
    }

    /**
     * Registers a new user in the database.
     * @param username
     * @param password
     * @param isAdmin  true if the new user is an administrator, false otherwise.
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
