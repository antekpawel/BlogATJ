<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Register</title>


</head>
<body>
<h1>Welcome, please register:</h1>
<form action="/RegisterAuthenticationServlet" method="post">

  username: <input type="text" name="username" width="30"/>
  password: <input type="text" name="password" width="10"/>

  <input type="submit" value="Login"/>
</form>
</body>
</html>
