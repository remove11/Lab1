/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.bo;

import com.example.lab1.db.ItemDB;
import com.example.lab1.ui.ItemDTO;
import java.util.ArrayList;

/**
 * The `itemHandler` class provides functionality for managing items, including
 * saving new items, retrieving item lists, retrieving items by ID, and updating
 * item stock.
 */
public class itemHandler {

    /**
     * Saves item to database
     * @param itemDTO The ItemDTO object representing the item to be saved.
     */
    public static void save(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getTitle(), itemDTO.getPrice(), itemDTO.getStock());
        ItemDB.saveToDb(item);
    }

    /**
     * Retrieves a list of items from the database.
     * @return An ArrayList of ItemDTO objects representing the retrieved items.
     */
    public static ArrayList<ItemDTO> getItems() {
        ArrayList<Item> items = ItemDB.getItems();

        ArrayList<ItemDTO> value = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            value.add(new ItemDTO(items.get(i).getId(), items.get(i).getTitle(), items.get(i).getPrice(), items.get(i).getStock()));
        }
        return (ArrayList<ItemDTO>) value.clone();
    }

    /**
     * Retrieves an item by its unique ID.
     * @param id The ID of the item to retrieve.
     * @return An ItemDTO object representing the retrieved item
     */
    public static ItemDTO getItemByID(int id) {
        Item item = ItemDB.getItemById(id);
        if (item != null) {
            return new ItemDTO(item.getId(), item.getTitle(), item.getPrice(), item.getStock());
        } else {
            return null;
        }
    }

    /**
     * Updates the stock of an item in the database.
     * @param item The ItemDTO object representing the item with updated stock.
     */
    public static void updateItemStock(ItemDTO item) {
        Item tmp = Item.createItem(item.getId(), item.getTitle(), item.getPrice(), item.getStock());
        ItemDB.updateItemStock(tmp);
    }
}
