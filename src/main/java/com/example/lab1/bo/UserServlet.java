package com.example.lab1.bo;

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
        if (loginDB.authenticate(username, password)) {
            // Inloggning lyckades
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            if (loginDB.isAdmin(username)){
                session.setAttribute("isAdmin", true);
                response.sendRedirect("ItemInsert.jsp"); // Ersätt med din målsida
            }else {
                session.setAttribute("isAdmin",false);
                response.sendRedirect("index.jsp");
            }
        } else {
            // Inloggning misslyckades
            request.setAttribute("errorMessage", "Felaktigt användarnamn eller lösenord");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Hämta användarens session (om den finns)
        HttpSession session = request.getSession(false);

        if (session != null) {
            // Ogiltigförklara sessionen (logga ut)
            session.invalidate();
        }

        // Omdirigera till startsidan eller inloggningssidan
        response.sendRedirect("index.jsp"); // Byt ut med din önskade sida
    }

}

