<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ page import="com.javaproject.hungrybarfinal.model.ProfileModel" %>
<!DOCTYPE html>
<html>
<head>
    <title>Profile</title>
</head>
<body>
    <h1>Profile</h1>
    <%
        ProfileModel profile = (ProfileModel) request.getAttribute("profile");
        if (profile != null) {
    %>
        <p><strong>Name:</strong> <%= profile.getName() %></p>
        <p><strong>Email:</strong> <%= profile.getEmail() %></p>
        <p><strong>Profile Picture:</strong> <img src="<%= profile.getProfilePicture() %>" alt="Profile Picture" width="100"></p>
        <p><strong>Phone Number:</strong> <%= profile.getPhoneNumber() != null ? profile.getPhoneNumber() : "Not provided" %></p>
        <p><strong>Address:</strong> <%= profile.getAddress() != null ? profile.getAddress() : "Not provided" %></p>
        <p><strong>Payment Details:</strong> <%= profile.getPaymentDetails() != null ? profile.getPaymentDetails() : "Not provided" %></p>
    <%
        } else {
    %>
        <p style="color: red;">${errorMessage}</p>
    <%
        }
    %>
    <a href="home">Back to Home</a>
</body>
</html>