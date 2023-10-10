<%@ page import="com.example.lab1.bo.Cart" %>
<%@ page import="com.example.lab1.bo.Item" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab1.ui.ItemDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Shopping Cart</title>
  <%-- Css style --%>
  <style>
    body, html {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: #f5f5f5;
      color: #333;
    }

    h2 {
      color: #444;
      text-align: center;
      margin-top: 20px;
    }

    .container {
      max-width: 600px;
      margin: auto;
      background: white;
      padding: 20px 40px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      margin-bottom: 20px;
    }

    table {
      width: 100%;
      border-collapse: collapse;
      margin-bottom: 20px;
    }

    th, td {
      padding: 10px;
      border: 1px solid #ccc;
      text-align: left;
    }

    th {
      background-color: #f0f0f0;
    }

    button[type="submit"] {
      background-color: #28a745;
      color: white;
      border: none;
      cursor: pointer;
      padding: 10px 20px;
      border-radius: 4px;
      transition: background-color 0.3s ease;
    }

    button[type="submit"]:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>

<jsp:include page="topbar.jsp"/>

<div class="container">
  <h2>Your Shopping Cart</h2>

  <%
    Cart cart = (Cart) session.getAttribute("cart");
    if(cart != null && cart.getItems().size() > 0) {
      List<ItemDTO> items = cart.getItems();
      double totalPrice = 0;
  %>
  <table>
    <tr>
      <th>Title</th>
      <th>Price</th>
      <th>Actions</th>
    </tr>
    <% for(ItemDTO item : items) {
      if(item != null) {
        totalPrice += item.getPrice();
    %>
    <tr>
      <td><%= item.getTitle() %></td>
      <td>$<%= item.getPrice() %></td>
      <td>
        <form action="removeFromCart" method="post">
          <input type="hidden" name="itemId" value="<%= item.getId() %>">
          <button type="submit">Remove</button>
        </form>
      </td>
    </tr>
    <%
        }
      }
    %>
  </table>

  <p>Total Price: $<%= totalPrice %></p>
  <form action="checkout" method="post">
    <button type="submit">Checkout</button>
  </form>
  <% } else { %>
  <p>Your cart is empty</p>
  <% } %>

  <a href="/items">Continue Shopping</a>
</div>

</body>
</html>