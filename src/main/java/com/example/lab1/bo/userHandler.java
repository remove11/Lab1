/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */
package com.example.lab1.bo;
import com.example.lab1.db.userDB;
import com.example.lab1.ui.UserDTO;

/**
 * userHandler kollar user i db
 */
public class userHandler {
    /**
     * Kollar om user finns
     * @param userName
     * @param password
     * @return userDTO eller null om user inte finns
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
     * Kollar om user är admin
     * @param username
     * @return true om admin
     */
    public static boolean isAdmin(String username) {
        return userDB.isAdmin(username);
    }

    /**
     * Registrerar en ny user via db
     * @param username  username.
     * @param password  password
     * @param admin    `true` if the new user is admin
     */
    public static void register(String username, String password, boolean admin) {
        userDB.register(username, password, admin);
    }
}
