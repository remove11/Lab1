package com.example.lab1.ui;

import com.example.lab1.bo.userHandler;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
/**
 * The `UserServlet` class is a servlet responsible for user functions.
 * It handles HTTP requests for these actions and interacts with the `userHandler` class for user data.
 */
@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {

    /**
     * Handles the login action by validating the user's credentials.
     * @param request  The HTTP request containing user input.
     * @param response The HTTP response to be sent back to the client.
     * @throws ServletException If a servlet-related error occurs.
     * @throws IOException      If an I/O error occurs.
     */
    private void login(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");


        UserDTO user = userHandler.authenticate(username, password);

        if (user != null) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);

            if (userHandler.isAdmin(username)) {
                session.setAttribute("isAdmin", true);
                response.sendRedirect("ItemInsert.jsp");
            } else {
                session.setAttribute("isAdmin", false);
                response.sendRedirect("index.jsp");
            }
        } else {
            // Failed login
            System.out.println("Login Failed");
            request.setAttribute("errorMessage", "Invalid username or password");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    /**
     * Handles user registration.
     */
    private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        boolean isAdmin = (request.getParameter("isAdmin") != null);


        userHandler.register(username, password, isAdmin);

        response.sendRedirect("login.jsp");
    }

    /**
     * Handles HTTP POST requests.
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if (action.equals("login")) {
            login(req, resp);
        } else if (action.equals("register")) {
            register(req, resp);
        }
    }

    /**
     * Handles HTTP GET requests.
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }

        response.sendRedirect("index.jsp");
    }
}
