/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.bo;
import com.example.lab1.db.ItemDB;
import com.example.lab1.ui.ItemDTO;
import java.util.ArrayList;

/**
 * itemHandler sparar items i databasen via itemDTO
 */
public class itemHandler {

    /**
     * Skapar item via ItemDTO
     * @param itemDTO
     */
    public static void save(ItemDTO itemDTO) {
        Item item = new Item(itemDTO.getTitle(), itemDTO.getPrice(), itemDTO.getStock());
        ItemDB.saveToDb(item);
    }

    /**
     * Hämtar en lista från databasen
     * @return clone av ArrayList med ItemDTO objects
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
     * Hämtar item med id
     * @param id
     * @return om de inte finns de item så returerar null annars en kopia på item
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
     * Uppdaterar stock i databasen via itemDB.update...
     * @param item
     */
    public static void updateItemStock(ItemDTO item) {
        Item tmp = Item.createItem(item.getId(), item.getTitle(), item.getPrice(), item.getStock());
        ItemDB.updateItemStock(tmp);
    }
}
