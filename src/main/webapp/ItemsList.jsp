<%@ page import="com.example.lab1.db.DBManager" %>
<%@ page import="com.example.lab1.bo.Item" %>
<%@ page import="com.example.lab1.db.ItemDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page import="com.example.lab1.ui.ItemDTO" %>
<%@ page import="com.example.lab1.bo.itemHandler" %>
<%@ page import="java.util.List" %>
<%@ page import="com.example.lab1.ui.HelloServlet" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Items</title>
  <style>
    body, html {
      margin: 0;
      padding: 0;
      font-family: Arial, sans-serif;
      background: #f5f5f5;
      color: #333;
    }

    h1 {
      color: #444;
      font-size: 2em;
      text-align: center;
      margin-top: 20px;
    }

    .container {
      max-width: 1200px;
      margin: auto;
      background: white;
      padding: 20px 40px;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      margin-bottom: 20px;
    }

    .product-grid {
      display: grid;
      grid-template-columns: repeat(auto-fill, minmax(200px, 1fr));
      gap: 20px;
      padding: 20px;
    }

    .product {
      background: white;
      padding: 20px;
      border: 1px solid #ddd;
      border-radius: 5px;
      box-shadow: 0 2px 4px rgba(0,0,0,0.1);
      text-align: center;
    }

    .product h2 {
      margin: 0 0 10px 0;
      font-size: 1.2em;
    }

    .price {
      color: green;
      font-size: 1.2em;
    }

    button[type="submit"] {
      background-color: #28a745;
      color: white;
      border: none;
      cursor: pointer;
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
  <h1>Current Items</h1>

  <%
    String title = request.getParameter("title");
    if (title != null && !title.isEmpty()) {
      int price = Integer.parseInt(request.getParameter("price"));
      int stock = Integer.parseInt(request.getParameter("stock"));
      ItemDTO item = new ItemDTO(title, price, stock);
      itemHandler.save(item);
  %>
  <p style="color: green; text-align: center;">Item Added Successfully!</p>
  <%
    }
  %>

  <div class="product-grid">
    <%
      List<ItemDTO> items = (List<ItemDTO>) itemHandler.getItems();
      if (items != null) {
        for (int i =0; i<items.size(); i++) {
          ItemDTO item = items.get(i);
    %>
    <div class="product">
      <h2><%= item.getTitle() %></h2>
      <p class="price">$<%= item.getPrice() %></p>
      <p>Stock: <%= item.getStock() %></p>
      <form action="addToCart" method="post">
        <input type="hidden" name="itemId" value="<%= item.getId() %>">
        <%
          String buttonAttribute = "";
          String buttonText = "Add to Cart";
          if (item.getStock() <= 0){
            buttonAttribute = "disabled";
            buttonText = "Out of Stock";
          }
        %>
        <button type="submit" <%=buttonAttribute%>><%=buttonText%></button> <!-- Modified this line -->
      </form>
    </div>
    <%
        }
      }
    %>
  </div>
</div>
</body>
</html>