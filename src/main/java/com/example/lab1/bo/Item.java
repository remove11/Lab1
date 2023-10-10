/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.bo;

public class Item {
    private int id;
    private String title;
    private int price;
    private int stock;


    public static Item createItem(int id, String title, int price, int stock){
            return new Item(id,title, price, stock);
    }


    protected Item(int id,String title, int price, int stock) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    protected Item(String title, int price, int stock)
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

