<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javaproject.hungrybarfinal.model.UserModel" %>
<html>
<head>
    <title>Home</title>
</head>
<body>
    <h1>Welcome to Hungry Bar!</h1>
    <%
        UserModel user = (UserModel) session.getAttribute("user");
        String userID = (String) session.getAttribute("userID");
        if (user != null) {
    %>
        <p>Welcome, <%= user.getName() %>!</p>
        <p>Your UserID: <%= userID %></p>
        <p>Your role: <%= user.getRole() %></p>
        <a href="logout">Logout</a>
    <%
        } else {
            response.sendRedirect("login");
        }
    %>
</body>
</html>