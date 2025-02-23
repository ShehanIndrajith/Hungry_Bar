<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.javaproject.hungrybarfinal.model.ProfileModel" %>
<html>
<head>
    <title>Edit Profile</title>
</head>
<body>
    <h1>Edit Profile</h1>
    <%
        ProfileModel profile = (ProfileModel) request.getAttribute("profile");
        if (profile != null) {
    %>
        <form action="edit-profile" method="post">
    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= profile.getName() %>" disabled><br>

    <label for="email">Email:</label>
    <input type="email" id="email" name="email" value="<%= profile.getEmail() %>" disabled><br>

    <label for="phoneNumber">Phone Number:</label>
    <input type="text" id="phoneNumber" name="phoneNumber" value="<%= profile.getPhoneNumber() != null ? profile.getPhoneNumber() : "" %>" required><br>

    <label for="address">Address:</label>
    <input type="text" id="address" name="address" value="<%= profile.getAddress() != null ? profile.getAddress() : "" %>"><br>

    <label for="paymentDetails">Payment Details:</label>
    <input type="text" id="paymentDetails" name="paymentDetails" value="<%= profile.getPaymentDetails() != null ? profile.getPaymentDetails() : "" %>"><br>

    <label for="profilePicture">Profile Picture URL:</label>
    <input type="text" id="profilePicture" name="profilePicture" value="<%= profile.getProfilePicture() != null ? profile.getProfilePicture() : "" %>"><br>

    <input type="submit" value="Save">
</form>
<p style="color: red;">${errorMessage}</p>
    <%
        } else {
    %>
        <p style="color: red;">${errorMessage}</p>
    <%
        }
    %>
    <a href="profile">Back to Profile</a>
</body>
</html>