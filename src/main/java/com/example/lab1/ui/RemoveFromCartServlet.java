package com.example.lab1.ui;

import com.example.lab1.bo.Cart;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/removeFromCart")
public class RemoveFromCartServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String itemId = request.getParameter("itemId");
        if (itemId != null && !itemId.isEmpty()) {
            Cart cart = (Cart) request.getSession().getAttribute("cart");
            if (cart != null) {
                cart.removeItem(Integer.parseInt(itemId));
            }
        }
        response.sendRedirect("cart.jsp");
    }
}
