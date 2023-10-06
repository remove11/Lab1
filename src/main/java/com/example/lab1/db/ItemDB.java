package com.example.lab1.db;

import com.example.lab1.bo.Item;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {
    public static Collection searchItems(String group) throws SQLException {
        Vector v = new Vector();
        Connection con = DBManager.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select item_id, name from Item where item_group = " + group);
        while (rs.next()) {
            int i = rs.getInt("item_id");
            String name = rs.getString("name");
        }
        return v;
    }

    public static Item getItemById(int itemId) throws SQLException {
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
            throw new SQLException("Error fetching item with ID: " + itemId, e);
        }
        return item;
    }

    private ItemDB(String title, int price, int stock) {
        super(title, price, stock);
    }

    public static void updateItemStock(Item item) throws SQLException {
        Connection con = DBManager.getConnection();
        String query = "UPDATE Items SET stock = ? WHERE id = ?";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setInt(1, item.getStock());
            ps.setInt(2, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new SQLException("Error updating stock for item with ID: " + item.getId(), e);
        }
    }

    public static void saveToDb(Item i) throws SQLException {
        Connection con = DBManager.getConnection();
        String query = "INSERT INTO Items (title, price, stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ps.setString(1, i.getTitle());
            ps.setInt(2, i.getPrice());
            ps.setInt(3, i.getStock());
            ps.execute();
        }
    }

    public static ArrayList<Item> getItems() throws SQLException {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = DBManager.getConnection();
        String query = "SELECT * FROM Items";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String title = rs.getString("title");
                int id = rs.getInt("id");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                Item item = Item.createItem(id, title, price, stock);
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



}