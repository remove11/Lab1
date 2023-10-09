<%@ page import="com.example.lab1.bo.Cart" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%  session = request.getSession(false); %>
<% String username = (session != null) ? (String) session.getAttribute("username") : null; %>
<%
    Cart cart = (Cart) session.getAttribute("cart");
    int cartSize = (cart != null && cart.getItems() != null) ? cart.getItems().size() : 0;
%>

<header>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #333;
            color: white;
            padding: 10px 20px;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }

        nav {
            display: flex;
            gap: 20px;
        }

        nav a {
            color: white;
            text-decoration: none;
        }

        .cart {
            position: relative;
        }

        .cart-count {
            background-color: red;
            color: white;
            border-radius: 50%;
            padding: 2px 6px;
            font-size: 12px;
            position: absolute;
            top: -10px;
            right: -10px;
        }
        button {
            padding: 10px 20px;
            border: none;
            border-radius: 4px;
            background-color: #28a745;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

    </style>
    <nav>
        <a href="ItemInsert.jsp">Insert Item</a>
        <a href="items">Items List</a>


        <% if (username != null) { %>
        <li><span>Hello, <%= username %>!</span></li>
        <form id="LogoutForm" action="UserServlet" method="get">
            <button type="submit">Logout</button>
        </form>
        <% }else{%>
        <a href="login.jsp">Login</a>
        <a href="RegisterUser.jsp">Register</a>
        <%}%>
    </nav>
    <div class="cart">
        <a href="cart.jsp"><img src="cart-icon.png" alt="Shopping Cart"></a>
        <div class="cart-count"><%= cartSize %></div> <!-- Display cart size here -->
    </div>
</header>
