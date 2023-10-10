package com.example.lab1.db;

import com.example.lab1.bo.Item;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Vector;

public class ItemDB extends Item {
   /* public static Collection searchItems(String group) throws SQLException {
        Vector v = new Vector();
        Connection con = DBManager.getConnection();
        Statement st = con.createStatement();
        ResultSet rs = st.executeQuery("select item_id, name from Item where item_group = " + group);
        while (rs.next()) {
            int i = rs.getInt("item_id");
            String name = rs.getString("name");
            //v.addElement(new ItemDB(i, name));
        }
        return v;
    }*/

    private ItemDB(String title, int price, int stock) {
        super(title, price, stock);
    }

    public static void saveToDb(Item i) {
        Connection con = DBManager.getConnection();

        String query = "INSERT INTO Items (title, price, stock) VALUES (?, ?, ?)";
        try (PreparedStatement ps = con.prepareStatement(query); ) {
            ps.setString(1, i.getTitle());
            ps.setInt(2, i.getPrice());
            ps.setInt(3, i.getStock());
            ps.execute();
        }catch (SQLException s){
            s.printStackTrace();
        }
        System.out.println("Item have been added to DB=" + i.getTitle());
    }
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
    public static void updateItemStock(Item item)  {
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


    public static ArrayList<Item> getItems(){
        ArrayList<Item> list = new ArrayList<>();
        Connection con = DBManager.getConnection();
        String query = "SELECT * FROM Items";
        try (PreparedStatement ps = con.prepareStatement(query)) {
            ResultSet rs = ps.executeQuery();  // Execute the query right away since there are no parameters to set
            while (rs.next()) {
                int id = rs.getInt("ID");
                String title = rs.getString("title");
                int price = rs.getInt("price");
                int stock = rs.getInt("stock");
                Item item =  createItem(id,title, price, stock);  // Using factory method to create Item object
                list.add(item);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

}