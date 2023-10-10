/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */
package com.example.lab1.bo;
import com.example.lab1.ui.ItemDTO;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Cart {
    /**
     * Cart håller lista med items
     */
    private List<ItemDTO> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    /**
     * Används vid checkout processen och tömmer korgen
     */
    public void clear(){
        items.clear();
    }

    /**
     * Tar bort ett item i taget baserat på id
     * @param itemId
     */
    public void removeItem(int itemId) {
        Iterator<ItemDTO> iterator = items.iterator();
        while (iterator.hasNext()) {
        ItemDTO item = iterator.next();
            if (item.getId() == itemId) {
                iterator.remove();
                break;
            }
        }
    }
}