<%--
  User: Alexander Fredholm & George Bahadi
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<%
    Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
    if (isAdmin != null && isAdmin) {
%>
<html>
<head>
    <title>Insert New Item</title>
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
            text-align: center;
            margin-top: 20px;
        }

        .container {
            max-width: 600px; /* Adjusted the width for the form */
            margin: auto;
            background: white;
            padding: 20px 40px;
            border-radius: 5px;
            box-shadow: 0 2px 4px rgba(0,0,0,0.1);
            margin-bottom: 20px;
        }

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #444;
        }

        input[type="text"],
        input[type="number"],
        input[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
            border: 1px solid #ccc;
        }

        input[type="submit"] {
            background-color: #28a745;
            color: white;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
    </style>
</head>
<body>

<jsp:include page="topbar.jsp"/>

<div class="container">
    <h1>Insert New Item</h1>
    <form action="items" method="post"> <!-- doPost -->
        <label for="title">Title:</label>
        <input type="text" id="title" name="title" required>
        <label for="price">Price:</label>
        <input type="number" id="price" name="price" step="0.01" required>
        <label for="stock">Stock:</label>
        <input type="number" id="stock" name="stock" required>
        <input type="submit" value="Insert Item">
    </form>
</div>
</body>
</html>
<%
} else {
%>
<html>
<head>
    <title>Access Denied</title>
</head>
<jsp:include page="topbar.jsp"/>
<body>
<h1>Access Denied</h1>
<p>You do not have permission to access this page.</p>
</body>
</html>
<%
    }
%>


