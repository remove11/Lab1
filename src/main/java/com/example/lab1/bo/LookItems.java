package com.example.lab1.bo;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class LookItems {

    public Hashtable<String, Object> getItemsWithGroup(String s) throws SQLException {
        Collection<Item> c = Item.searchItems(s); // Antagen metod som returnerar en samling av objekt av typen Item
        Hashtable<String, Object> t = new Hashtable<>();
        t.put("size", c.size());

        int index = 0;
        for (Iterator<Item> it = c.iterator(); it.hasNext(); index++) {
            Hashtable<String, Object> item = new Hashtable<>();
            Item currentItem = it.next();
            item.put("name", currentItem.getTitle());
            item.put("price", currentItem.getPrice());
            t.put("Item" + index, item);
        }
            return t;
        }
    }


