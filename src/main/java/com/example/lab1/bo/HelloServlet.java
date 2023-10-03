package com.example.lab1.bo;

import java.io.*;
import java.sql.SQLException;
import com.example.lab1.db.DBManager;
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

        //DBManager.add(title, ) här kommer man kunna skicka vidare de som skrivs i form.


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>post</h1>");
        out.println("<h1>doPost</h1>");
        out.println("<h1>"+title+"</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}