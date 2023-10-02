package com.example.lab1;

import java.io.*;

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
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");



        DBManager.getConnection();

        String title = request.getParameter("title");

        //DBManager.add(title, ) här kommer man kunna skicka vidare de som skrivs i form.


        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>post</h1>");
        out.println("<h1>"+title+"</h1>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");

    }

    public void destroy() {
    }
}