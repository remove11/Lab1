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
        ResultSet rs = st.executeQuery("select item_id, name from Item where item_group = "+group);
        while (rs.next())
        {
            int i = rs.getInt("item_id");
            String name = rs.getString("name");
           //v.addElement(new ItemDB(i, name));
        }
        return v;
    }
    private ItemDB(String title, int price, int stock) {
        super(title, price, stock);
    }

    public static void saveToDb(Item i) throws SQLException {
        Connection con = DBManager.getConnection();
        String query = "INSERT INTO Items (title, price, stock) VALUES (?, ?, ?)";
        try(PreparedStatement ps = con.prepareStatement(query)){
            ps.setString(1, i.getTitle());
            ps.setInt(2, i.getPrice());
            ps.setInt(3, i.getStock());
            ps.execute();
        }
        System.out.println("Item have been added to DB=" + i.getTitle());
    }
<<<<<<< Updated upstream
    //xd
=======

    public static ArrayList<Item> getItems() throws SQLException {
        ArrayList<Item> list = new ArrayList<>();
        Connection con = DBManager.getConnection();
        String query = "SELECT * FROM Items";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();  // Execute the query right away since there are no parameters to set
            while (rs.next()) {
                String title = rs.getString("title");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                Item item = Item.createItem(title, price, stock);  // Using factory method to create Item object
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

>>>>>>> Stashed changes
}

