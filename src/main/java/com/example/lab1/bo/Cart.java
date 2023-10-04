package com.example.lab1.bo;

import java.util.List;

public class Cart {
    private int id;
    private int userId;
    private List<Item> items;

    protected Cart(int id, int userId, List<Item> items) {
        this.id = id;
        this.userId = userId;
        this.items = items;
    }

    public void createCart(){

    }

}