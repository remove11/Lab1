package com.example.lab1.ui;

public class ItemDTO
{
    private int id;
    private String title;
    private int price;
    private int stock;

    public ItemDTO(int id,String title, int price, int stock) {

        this.id = id;
        this.title = title;
        this.price = price;
        this.stock = stock;
    }
    public ItemDTO(String title, int price, int stock) {
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
