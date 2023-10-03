package com.example.lab1;

import com.example.lab1.db.loginDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        // Anropa en tjänst i ditt datalager för att kontrollera inloggningen
        loginDB userService = new loginDB(); // Du behöver implementera UserService

        if (userService.authenticate(username, password)) {
            // Inloggning lyckades
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("ItemInsert.jsp"); // Ersätt med din målsida
        } else {
            // Inloggning misslyckades
            request.setAttribute("errorMessage", "Felaktigt användarnamn eller lösenord");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}

