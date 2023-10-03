<%--
  Created by IntelliJ IDEA.
  User: alexf
  Date: 2023-10-02
  Time: 16:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.io.*, java.util.*" %>

<%
    // Check if the user is an admin
    Boolean isAdmin = (Boolean) session.getAttribute("isAdmin");
    if (isAdmin != null && isAdmin) {
%>
<html>
<head>
    <title>Insert New Item</title>
</head>
<body>
<jsp:include page="Header.jsp" />
<h1>Insert New Item</h1>
<form action="hello-servlet" method="post"> <!-- Use your actual servlet URL -->
    <label for="title">Title:</label>
    <input type="text" id="title" name="title" required><br><br>

    <label for="price">Price:</label>
    <input type="number" id="price" name="price" step="0.01" required><br><br>

    <label for="stock">Stock:</label>
    <input type="number" id="stock" name="stock" required><br><br>

    <input type="submit" value="Insert Item">
</form>
</body>
</html>
<%
} else {
%>
<html>
<head>
    <title>Access Denied</title>
</head>
<body>
<h1>Access Denied</h1>
<p>You do not have permission to access this page.</p>
</body>
</html>
<%
    }
%>

