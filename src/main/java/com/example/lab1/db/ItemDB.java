/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.db;
import com.example.lab1.bo.Item;

import java.sql.*;
import java.util.ArrayList;

/**
 * Hanterar kontakt med db
 */
public class ItemDB extends Item {

    private ItemDB(String title, int price, int stock) {
        super(title, price, stock);
    }

    /**
     * Sparar item till db
     * @param item
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
     * Hämtar item med id.
     * @param itemId
     * @return item
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
     * Uppdaterar item i db
     * @param item
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
     * Ger en lista med items från db
     * @return list
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