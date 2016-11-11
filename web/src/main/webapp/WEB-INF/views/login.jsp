<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<form action="/j_spring_security_check" name='loginForm' method="post">
    <label>Login</label>
    <input name="username">
    <label>Password</label>
    <input type="password" name="password">
    <input type="submit" value="login">
</form>
</body>
</html>