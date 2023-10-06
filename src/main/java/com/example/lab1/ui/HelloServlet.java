package com.example.lab1.ui;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import com.example.lab1.bo.Item;
import com.example.lab1.bo.itemHandler;
import com.example.lab1.db.DBManager;
import com.example.lab1.db.ItemDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/items")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

        message = "Hello World666!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        List<ItemDTO> itemDTOList = getItems();
        request.setAttribute("items", itemDTOList);
        request.getRequestDispatcher("/ItemsList.jsp").forward(request, response);
        // Hello

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) {
        response.setContentType("text/html");
        //DBManager.getConnection();
        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        ItemDTO item = new ItemDTO(title, price, stock);
        itemHandler.save(item);
    }

    public static ArrayList<ItemDTO> getItems(){

       return itemHandler.getItems();
    }

    public void destroy() {
    }
}