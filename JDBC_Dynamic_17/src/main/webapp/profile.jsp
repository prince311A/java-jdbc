<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Profile</title>
</head>
<body>
<h2>Welcome to Profile</h2>
<%
String name = (String)session.getAttribute("name_key");
String city = (String)session.getAttribute("city_key");
String gender = (String)session.getAttribute("gender_key");
String sno = (String)session.getAttribute("sno_key");
%>
<h3>Heyyyyyy!!!<%=name%></h3>
<h4>Unique ID:<%=sno%></h4>
Gender:<%=gender %>
<br>
City:<%=city %>
<br><br>
<a href = "Logout">Logout</a>
</body>
</html>