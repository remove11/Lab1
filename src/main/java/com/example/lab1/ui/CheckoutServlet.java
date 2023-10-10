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

@WebServlet("/checkout")
public class CheckoutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart != null && cart.getItems().size() > 0) {
            for (ItemDTO item : cart.getItems()) {
                item.setStock(item.getStock()-1);
                itemHandler.updateItemStock(item);
            }
            cart.clear();
        }
        response.sendRedirect("cart.jsp");
    }
}