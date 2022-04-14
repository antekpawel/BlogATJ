<%@ page import="pw.edu.atj.blogatj.model.User" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<!-- Wyświetlenie nazwy użytkownika. -->

<body>
<% boolean validUser = (boolean) request.getAttribute("validUser"); %>
<% if(validUser) { %>
    <p> username is valid</p>
<% } else { %>
    <p> Username is not valid!</p>

    <p>Go back to login page </p>
    <a href="index.jsp">Login!</a>

    <p>or go to register page. </p>
    <a href="/RegisterServlet">Register!</a>
<% } %>

<p>Go to blog: </p>
<a href="/blog">Blog</a>

</body>
</html>
