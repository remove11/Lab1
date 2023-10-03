package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;

import java.sql.SQLException;
import java.util.Collection;

public class Item {
    private int id;
    private String name;
    private int price;
    private int stock;

     static public Collection searchItems(String group) throws SQLException {
        return ItemDB.searchItems(group);
    }
    protected Item(int id , String name,int stock,int price) {
        this.id = id;
        this.name = name;
        this.stock = stock;
    }
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}

