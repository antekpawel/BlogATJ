<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Register authentication</title>
</head>
<body>
<%
    boolean userExist = (boolean) request.getAttribute("userExist");
    if (!userExist){
%>
    <p> You have been successfully registered!</p>
    <a href="/index.jsp">Go to login!</a>
<% } else { %>
    <p> Opps, something goes wrong!</p>
    <a href="/RegisterServlet">Back to registration!</a>
<% } %>
</body>
</html>
