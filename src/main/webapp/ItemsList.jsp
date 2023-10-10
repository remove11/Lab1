<%--
  User: Alexander Fredholm & George Bahadi
--%>
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
    <%-- Css style --%>
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

    button {
      padding: 10px 20px;
      border: none;
      border-radius: 4px;
      background-color: #28a745;
      color: white;
      cursor: pointer;
      transition: background-color 0.3s ease;
    }

    button:hover {
      background-color: #218838;
    }
  </style>
</head>
<body>

<jsp:include page="topbar.jsp"/> <!-- This line includes the top bar -->

<div class="container">
  <h1>Current Items</h1>
   <div class="product-grid">
       <%
         ArrayList<ItemDTO> items;
           items = (ArrayList<ItemDTO>) request.getAttribute("items");
           for (ItemDTO item : items) {
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
     %>
  </div>
</div>
</body>
</html>