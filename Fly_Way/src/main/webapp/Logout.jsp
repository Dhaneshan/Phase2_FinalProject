<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Logout</title>
</head>
<body>
<%
session.invalidate();
out.println("You have successfully Logged Out");
%>
<br/><br/>
<a href="Login.html">Return to Main Menu</a>
</body>
</html>