
<%--
  User: Alexander Fredholm & George Bahadi
--%>

<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%-- Check if the user is logged in --%>
<%  session = request.getSession(false); %>
<% String username = (session != null) ? (String) session.getAttribute("username") : null; %>

<html>
<head>
  <title>Items</title>
  <%-- Css style --%>
  <style>
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



    .product h2 {
      margin: 0;
      font-size: 1.2em;
    }

    .price {
      color: green;
      font-size: 1.2em;
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
  </style>
</head>
<body>
<header>
  <div class="cart">
    <a href="#"><img src="cart-icon.png" alt="Shopping Cart"></a>
    <div class="cart-count">0</div>
  </div>
  <nav>
    <ul>
      <% if (username != null) { %>
      <li><span>Hello, <%= username %>!</span></li>
        <form id="LogoutForm" action="UserServlet" method="get">
          <button type="submit">Logout</button>
        </form>
      <% }else{%>
        <nav>
          <a href="#">Sign In</a>
          <a href="#">Register</a>
          <a href="#">Add Item</a>
        </nav>
      <%}%>
    </ul>
  </nav>
</header>
</body>
</html>

