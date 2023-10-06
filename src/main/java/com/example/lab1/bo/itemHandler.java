package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;
import com.example.lab1.ui.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

public class itemHandler
{

   /* public static Collection<ItemDTO> searchItems(String group) throws SQLException {
       Collection items = ItemDB.searchItems(group);
       Collection<ItemDTO> value = new ArrayList<>();
        while (items.iterator().hasNext()){
            value.add(new ItemDTO())
        }
        return ItemDB.searchItems(group);
    }*/

    public static void save(ItemDTO itemDTO)  {
        Item item = new Item(itemDTO.getId(),itemDTO.getTitle(),itemDTO.getPrice(),itemDTO.getStock());
        ItemDB.saveToDb(item);
    }

    public static Item createItem(String title, int price, int stock,int id){
        return new Item(id,title, price, stock);
    }
    public static ArrayList<ItemDTO> getItems(){
        ArrayList<Item> items = ItemDB.getItems();

        ArrayList<ItemDTO> value = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            value.add(new ItemDTO(items.get(i).getId(),items.get(i).getTitle(), items.get(i).getPrice(),items.get(i).getStock()));
        }
        return (ArrayList<ItemDTO>) value.clone();
    }
}
