package com.example.lab1.bo;

import com.example.lab1.db.userDB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
    private void login(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException
    {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        // Anropa en tjänst i ditt datalager för att kontrollera inloggningen
        if (userDB.authenticate(username, password)) {
            // Inloggning lyckades
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            if (userDB.isAdmin(username)){
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
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = (request.getParameter("isAdmin") != null); // Check if the isAdmin checkbox is checked

        // Anropa din register-metod för att lägga till användaren i databasen
        userDB.register(username, password, isAdmin);

        // Redirect to a confirmation page or wherever you want
        response.sendRedirect("login.jsp"); // Replace with your desired page
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if(action.equals("login")){
            login(req,resp);
        } else if (action.equals("register")) {
            register(req,resp);
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

