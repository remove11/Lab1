<%--
  Created by IntelliJ IDEA.
  User: alexf
  Date: 2023-09-29
  Time: 17:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <title>Login Page</title>
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

        label {
            font-weight: bold;
            display: block;
            margin-bottom: 5px;
            color: #444;
        }

        input[type="text"],
        input[type="password"],
        button[type="submit"] {
            width: 100%;
            padding: 10px;
            margin-bottom: 20px;
            border-radius: 4px;
        }

        input[type="text"],
        input[type="password"] {
            border: 1px solid #ccc;
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
    <h2>Login</h2>
    <form id="loginForm" action="LoginServlet" method="post">
        <label for="username">Username:</label>
        <input type="text" id="username" name="username" required>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" required>

        <button type="submit">Login</button>
    </form>
</div>

<script>
    const loginForm = document.getElementById('loginForm');

    loginForm.addEventListener('submit', function (event) {
        event.preventDefault();

        // Replace with your authentication logic
        const username = loginForm.elements.username.value;
        const password = loginForm.elements.password.value;

        // Simulate a simple authentication check (replace with your own logic)
        if (username === 'alex' && password === 'password') {
            alert('Login successful!'); // Replace with redirection or other actions
                window.location.href = "hello-servlet";
        } else {
            alert('Invalid username or password. Please try again.');
        }
    });
</script>
</body>
</html>
