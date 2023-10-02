package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;

import java.sql.SQLException;
import java.util.Collection;

public class Item {
    private int id;
    private String name;
    private int price;
    private int stock;

    public static Collection searchItems(String group) throws SQLException {
        return ItemDB.searchItems(group);
    }
    protected Item(int id , String name) {
        this.id = id;
        this.name = name;
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
    //xd
}

