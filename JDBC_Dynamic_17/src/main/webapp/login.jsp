<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>
<form action="Login" method = "post">
UserID:<input type = "text" name = "id" placeholder = "Enter UserId"> <br><br>
Password:<input type = "password" name = "password" placeholder = "Enter Password"><br><br>
<input type = "submit" value = "Login" name = "login">
<center> <a href = "index.jsp">Go To The Register Page</a> </center>
</form>
</body>
</html>