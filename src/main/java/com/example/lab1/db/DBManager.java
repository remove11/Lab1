package com.example.lab1.db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
    private static DBManager instance = null;
    private Connection con = null;

    private static DBManager getInstance(){
        if(instance == null) instance = new DBManager();
        return instance;
    }

    private DBManager(){
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost/webshopDB?user=root&password=snashen");
            System.out.println("Connected to DB" );
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Somthing wrong...");
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection(){
        return getInstance().con;
    }


}
