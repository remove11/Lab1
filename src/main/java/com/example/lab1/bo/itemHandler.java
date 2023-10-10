/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;
import com.example.lab1.ui.ItemDTO;
import java.util.ArrayList;

public class itemHandler{
    public static void save(ItemDTO itemDTO){
        Item item = new Item(itemDTO.getTitle(),itemDTO.getPrice(),itemDTO.getStock());
        ItemDB.saveToDb(item);
    }

    public static ArrayList<ItemDTO> getItems(){
        ArrayList<Item> items = ItemDB.getItems();
        ArrayList<ItemDTO> value = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            value.add(new ItemDTO(items.get(i).getId(),items.get(i).getTitle(), items.get(i).getPrice(),items.get(i).getStock()));
        }
        return (ArrayList<ItemDTO>) value.clone();
    }
    public static ItemDTO getItemByID(int id){
        Item item = ItemDB.getItemById(id);
        return new ItemDTO(item.getId(), item.getTitle(), item.getPrice(), item.getStock());
    }
    public static void updateItemStock(ItemDTO item){
        Item tmp  = Item.createItem(item.getId(),item.getTitle(),item.getPrice(), item.getStock());
        ItemDB.updateItemStock(tmp);
    }
}
