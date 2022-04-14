<%--
  Created by IntelliJ IDEA.
  User: pawel
  Date: 14.04.2022
  Time: 09:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<% boolean isPostRemoved = (boolean) request.getAttribute("isPostRemoved"); %>
<html>
<head>
    <title>Post remove</title>
</head>
<body>
<% if(isPostRemoved) { %>
    <p> Post successfully removed!</p>
<% } else { %>
    <p> Opps, something goes wrong!</p>
<% } %>

<p>Go to blog: </p>
<a href="/blog">Blog</a>

</body>
</html>
