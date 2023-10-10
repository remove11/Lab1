
/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */
package com.example.lab1.bo;

/**
 * Användare
 */
public class User {
    private int Id;
    private String name;
    private String password;
    private Boolean isAdmin;

    protected User(int id, String name, String password, Boolean isAdmin) {
        Id = id;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

    /**
     * Skapar en user via denna metod.
     */
    public static User createUser(int id, String name, String password, Boolean isAdmin) {
        return new User(id, name, password, isAdmin);
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", isAdmin=" + isAdmin +
                '}';
    }
}
