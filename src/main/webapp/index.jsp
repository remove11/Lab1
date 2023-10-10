<%--
  User: Alexander Fredholm & George Bahadi
--%>
<%@ page import="com.example.lab1.db.DBManager" %>
<%@ page import="com.example.lab1.bo.Item" %>
<%@ page import="com.example.lab1.db.ItemDB" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.sql.SQLException" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Alex & George Webshop</title>
    <%-- Css style --%>
    <style>
        body, html {
            margin: 0;
            padding: 0;
            font-family: Arial, sans-serif;
            background: #f5f5f5;
            color: #333;
        }

        .container {
            max-width: 1200px;
            margin: auto;
            background: white;
            padding: 20px 40px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-top: 20px;
            margin-bottom: 20px;
        }

        h1 {
            color: #444;
            font-size: 2em;
        }

        h2 {
            color: #666;
        }

        p {
            line-height: 1.6;
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
    </style>
</head>
<body>

<jsp:include page="topbar.jsp"/> <!-- Include the top bar -->

<div class="container">
    <h1>Welcome to Alex & George Webshop!</h1>
    <h2>Your One-Stop Online Store for Exclusive, High-Quality Products</h2>
    <p>
        At Alex & George Webshop, we're not just a regular online store -
        we're your reliable partner in the world of exclusive, top-tier products.
        Nestled in the digital space, we’ve created a sanctuary where quality, value,
        and customer satisfaction are as cherished as the valued customers we serve.
    </p>
</div>
</body>
</html>