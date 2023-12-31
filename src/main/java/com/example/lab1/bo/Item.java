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

    public static Item createItem(int id, String title, int price, int stock){
        return new Item(id, title, price, stock);
    }

    protected Item(String title, int price, int stock) {
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    protected Item(int id, String title, int price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    @Override
    public String toString() {
        return "Item{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", price=" + price +
                ", stock=" + stock +
                '}';
    }
}

