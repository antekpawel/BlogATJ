<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Welcome page Java EE</title>
</head>
<body>
<h1><%= "Hello!" %>
</h1>
<form method="post" action="/LoginValidationServlet">
    Username: <br />
    <input type="text" name="username" /><br />
    Password: <br />
    <input type="text" name="password" /><br />
    <input type="submit" value="Login">
</form>

<p>If you are new </p>
<a href="/RegisterServlet">Sign up</a>

</body>
</html>