
/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */
package com.example.lab1.bo;

/**
 * The `User` class represents a user in the system.
 */
public class User {
    private int Id;
    private String name;
    private String password;
    private Boolean isAdmin;

    /**
     * Constructs a new User object with the specified attributes.
     * @param id         The unique id
     * @param name       The name of the user.
     * @param password   The user's password.
     * @param isAdmin    whether the user is admin.
     */
    protected User(int id, String name, String password, Boolean isAdmin) {
        Id = id;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * Factory method to create a User object.
     */
    public static User createUser(int id, String name, String password, Boolean isAdmin) {
        return new User(id, name, password, isAdmin);
    }

    /**
     * Gets the id.
     * @return The user's identifier.
     */

    public int getId() {
        return Id;
    }

    /**
     * Sets the unique id
     * @param id The user's identifier.
     */
    public void setId(int id) {
        Id = id;
    }

    /**
     * Gets username.
     * @return The user's name.
     */
    public String getName() {
        return name;
    }

    /**
     * Sets username.
     * @param name The user's name.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Gets the password of the user.
     * @return The user's password.
     */
    public String getPassword() {
        return password;
    }

    /**
     * Sets the password of the user.
     * @param password The user's password.
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Checks if the user is admin.
     * @return `true` if the user is an administrator, `false` otherwise.
     */
    public Boolean getAdmin() {
        return isAdmin;
    }

    /**
     * Sets the user is admin.
     * @param admin `true` if the user is an administrator
     */
    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    /**
     * Returns a string representation of the User object.
     * @return A string containing user information.
     */

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
