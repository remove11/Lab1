package com.example.lab1.bo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<Item> getItems() {
        return items;
    }

    public void clear(){
        items.clear();
    }

    public void removeItem(int itemId) {
        Iterator<Item> iterator = items.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getId() == itemId) {
                iterator.remove();
                break;
            }
        }
    }
}