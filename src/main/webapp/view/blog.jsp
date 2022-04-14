<%@page import="java.util.List"%>
<%@page import="pw.edu.atj.blogatj.model.Post"%>
<%@ page import="pw.edu.atj.blogatj.model.User" %>
<%@ page import="pw.edu.atj.blogatj.model.UserService" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>


<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Blog Java EE</title>
</head>
<body>
<% List<Post> posts = (List<Post>) request.getAttribute("posts"); %>
<% UserService userService = new UserService(); %>
<% User user = (User) request.getAttribute("user"); %>
<% boolean validUser = userService.userIsValid(user); %>
<% if(validUser) { %>
    <form action="./blog" method="post">
        Your new post: <input type="text" name="blogPost">
        <br> <br>
        <input type="submit" value="Post">
    </form>
    <form action="./PostRemoveServlet" method="post">
        Put number of post to delete: <input type="text" name="noPost">
        <br> <br>
        <input type="submit" value="Remove">
    </form>
<% } else { %>
    <p> You are not logged.</p>
<% } %>
<table border="1" style="width: 50%" height="50%">
    <thead>
    <tr>
        <th>No.</th>
        <th>Date and time</th>
        <th>Username</th>
        <th>Post</th>
    </tr>
    </thead>
    <tbody>
    <% int i = 1; %>
    <% for(Post post : posts){ %>
    <tr>
        <td><%=i++%></td>
        <td><%=post.getTime()%></td>
        <td><%=post.getUser()%></td>
        <td><%=post.getText()%></td>
    </tr>
    <%} %>
    </tbody>

</table>
</body>
</html>