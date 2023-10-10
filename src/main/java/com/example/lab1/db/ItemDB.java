/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.db;
import com.example.lab1.bo.Item;

import java.sql.*;
import java.util.ArrayList;

/**
 * The `ItemDB` class provides database operations for managing items.
 */
public class ItemDB extends Item {

    /**
     * Constructs a new `ItemDB` object with the specified title, price, and stock.
     * This constructor is private to prevent direct instantiation.
     * @param title The title of the item.
     * @param price The price of the item.
     * @param stock The stock quantity of the item.
     */

    private ItemDB(String title, int price, int stock) {
        super(title, price, stock);
    }

    /**
     * Saves a new item to the database.
     *
     * @param item The Item object to be saved.
     */
    public static void saveToDb(Item item) {
        Connection con = DBManager.getConnection();

        String query = "INSERT INTO Items (title, price, stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, item.getTitle());
            ps.setInt(2, item.getPrice());
            ps.setInt(3, item.getStock());
            ps.execute();
        } catch (SQLException s) {
            s.printStackTrace();
        }
        System.out.println("Item has been added to the database: " + item.getTitle());
    }

    /**
     * Retrieves an item from the database by its unique ID.
     *
     * @param itemId The ID of the item to retrieve.
     * @return An Item object representing the retrieved item, or null if the item is not found.
     */
    public static Item getItemById(int itemId) {
        Connection con = DBManager.getConnection();
        String query = "SELECT * FROM Items WHERE id = ?";
        Item item = null;
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, itemId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                item = Item.createItem(id, title, price, stock);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return item;
    }

    /**
     * Updates the stock quantity of an item in the database.
     *
     * @param item The Item object representing the item with updated stock.
     */
    public static void updateItemStock(Item item) {
        Connection con = DBManager.getConnection();
        String query = "UPDATE Items SET stock = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, item.getStock());
            ps.setInt(2, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Retrieves a list of items from the database.
     *
     * @return An ArrayList of Item objects representing the retrieved items.
     */
    public static ArrayList<Item> getItems() {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = DBManager.getConnection();
        String query = "SELECT * FROM Items";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                Item item = createItem(id, title, price, stock);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}

