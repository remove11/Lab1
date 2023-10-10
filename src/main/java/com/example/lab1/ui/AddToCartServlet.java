/**
 * Lab1
 * Arthur: Alexander Fredholm & George Bahadi
 */

package com.example.lab1.ui;

import com.example.lab1.bo.Cart;
import com.example.lab1.bo.itemHandler;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

import javax.swing.plaf.basic.BasicComboBoxUI;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        int itemId = Integer.parseInt(request.getParameter("itemId"));
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null) {
            cart = new Cart();
        }
        ItemDTO item = itemHandler.getItemByID(itemId); ;
        cart.getItems().add(item);
        session.setAttribute("cart", cart);
        response.sendRedirect("/items");
    }
}

