package com.example.lab1.db;

import com.example.lab1.bo.Item;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
            int stock = rs.getInt("stock");
            int price = rs.getInt("price");
            v.addElement(new ItemDB(i, name,stock,price));
        }
        return v;
    }
    private ItemDB(int id, String name,int stock,int price) {
        super(id, name,stock,price);
    }

}

