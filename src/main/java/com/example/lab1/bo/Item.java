package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;

import java.sql.SQLException;
import java.util.Collection;

public class Item {
    private int id;
    private String title;
    private int price;
    private int stock;



    public static Item createItem(String title, int price, int stock){
            return new Item(title, price, stock);
    }


    public Item(int id,String title, int price, int stock) {

        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public Item(String title, int price, int stock)
    {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public String getTitle() {
        return title;
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

}

