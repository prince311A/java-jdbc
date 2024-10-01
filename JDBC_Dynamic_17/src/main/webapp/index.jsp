<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register Form</title>
</head>
<body>
<h3>Welcome to the Register Page</h3>
<form action="Register" method ="post">
Name <input type= "text" name = "name" placeholder = "Enter Name"><br><br>
Email <input type= "email" name = "email" placeholder = "Enter Email"><br><br>
City <input type= "text" name = "city" placeholder = "Enter City"><br><br>
Gender <input type= "radio" name = "gender" value = "male" >male <input type= "radio" name = "gender" value = "female" >female<br><br>
Password <input type= "password" name = "password" placeholder = "Enter Password"><br><br>
<input type= "submit" value = "Register" name = "register" >
<center> <a href = "login.jsp">Go To The Login Page</a> </center>
</form>
</body>
</html>

