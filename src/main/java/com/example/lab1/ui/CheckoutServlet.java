package com.example.lab1.ui;

import com.example.lab1.bo.Cart;
import com.example.lab1.bo.Item;
import com.example.lab1.bo.itemHandler;
import com.example.lab1.db.ItemDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && cart.getItems().size() > 0) {
            for (ItemDTO item : cart.getItems()) {
                item.setStock(item.getStock()-1); // Decrease the stock of each item by 1
                itemHandler.updateItemStock(item); // Update the item in the database to reflect the new stock
            }
            cart.clear();
        }
        response.sendRedirect("cart.jsp");
    }
}