package com.example.lab1.bo;

public class User
{
    private int Id;
    private String name;
    private String password;
    private Boolean isAdmin;

    public User(int id, String name, String password, Boolean isAdmin) {
        Id = id;
        this.name = name;
        this.password = password;
        this.isAdmin = isAdmin;
    }

}
