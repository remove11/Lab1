/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */
package com.example.lab1.bo;

import com.example.lab1.bo.User;
import com.example.lab1.db.userDB;
import com.example.lab1.ui.UserDTO;

/**
 * The `userHandler` class provides functionality related to user management,
 * including user authentication, checking if a user is an administrator, and user registration.
 */
public class userHandler {

    /**
     * Authenticates a user based on the provided username and password.
     * @param userName The username of the user attempting to authenticate.
     * @param password The password provided by the user.
     * @return A UserDTO object containing user information if authentication is successful, or null if authentication fails.
     */
    public static UserDTO authenticate(String userName, String password) {
        User user = userDB.authenticate(userName, password);
        if (user != null) {
            return new UserDTO(user.getId(), user.getName(), user.getPassword(), user.getAdmin());
        } else {
            return null;
        }
    }

    /**
     * Checks if a user with the specified username is an administrator.
     * @param username The username of the user to check.
     * @return true if the user is an administrator
     */
    public static boolean isAdmin(String username) {
        return userDB.isAdmin(username);
    }

    /**
     * Registers a new user with the provided username, password, and administrator status.
     * @param username  username.
     * @param password  password
     * @param admin    `true` if the new user is admin
     */
    public static void register(String username, String password, boolean admin) {
        userDB.register(username, password, admin);
    }
}
