package com.example.lab1.bo;

import java.io.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.example.lab1.db.DBManager;
import com.example.lab1.db.ItemDB;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;


@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {

        message = "Hello World666!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        DBManager.getConnection();

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>doGet</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");


        DBManager.getConnection();

        String title = request.getParameter("title");
        int price = Integer.parseInt(request.getParameter("price"));
        int stock = Integer.parseInt(request.getParameter("stock"));
        Item item = new Item(title, price, stock);
        try {
            item.save();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>Item Added</h1>");
        out.println("<h1>Current Items:</h1>");

        // Display items in a table
        out.println("<table border='1'>");
        out.println("<tr><th>Title</th><th>Price</th><th>Stock</th></tr>");
        ArrayList<Item> i = null;
        try {
            i = ItemDB.getItems();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        for (int j = 0; j < i.size(); j++) {
            out.println("<tr>");
            out.println("<td>" + i.get(j).getTitle() + "</td>");
            out.println("<td>" + i.get(j).getPrice() + "</td>");
            out.println("<td>" + i.get(j).getStock() + "</td>");
            out.println("</tr>");
        }
        out.println("</table>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}