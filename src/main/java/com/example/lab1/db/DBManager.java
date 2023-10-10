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
            con = DriverManager.getConnection("jdbc:mysql://localhost/webshopDB?user=root&password=g1234567");
            System.out.println("Connected to DB" );


            /*
            String insertItemSQL = "INSERT INTO Items (title, price, stock) VALUES ('pump', 29.00, 3)";
            int itemInserted = con.createStatement().executeUpdate(insertItemSQL);
            if (itemInserted > 0) {
                System.out.println("Item 'pump' inserted successfully.");
                ResultSet a = con.createStatement().executeQuery("select * from Items");
                ResultSet b = con.createStatement().executeQuery("select * from Users");
                while (a.next() && b.next()){
                    String username = b.getString("username");
                    Boolean admin = b.getBoolean("isAdmin");
                    System.out.println("username= " + username + " isAdmin= " + admin);
                    int itemID = a.getInt("ID");
                    String title = a.getString("title");
                    int price = a.getInt("price");
                    int stock = a.getInt("stock");

                    System.out.println("Item ID: " + itemID);
                    System.out.println("Title: " + title);
                    System.out.println("Price: " + price);
                    System.out.println("Stock: " + stock);
                }
            } else {
                System.out.println("Item insertion failed.");
            }
            */




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
