package com.example.lab1.bo;

import com.example.lab1.ui.ItemDTO;

import java.sql.SQLException;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

public class LookItems {

    /*public Hashtable<String, Object> getItemsWithGroup(String s) throws SQLException {
        Collection<ItemDTO> c = itemHandler.searchItems(s); // Antagen metod som returnerar en samling av objekt av typen Item
        Hashtable<String, Object> t = new Hashtable<>();
        t.put("size", c.size());

        int index = 0;
        for (Iterator<ItemDTO> it = c.iterator(); it.hasNext(); index++) {
            Hashtable<String, Object> item = new Hashtable<>();
            ItemDTO currentItem = it.next();
            item.put("name", currentItem.getTitle());
            item.put("price", currentItem.getPrice());
            t.put("Item" + index, item);
        }
            return t;
        }*/
    }


