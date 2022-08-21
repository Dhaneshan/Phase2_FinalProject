<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Administrator page</title>
<style type="text/css">
div
{ 
  width: 400px;
  border: 8px solid black ;
  padding: 20px;
  margin: 20px;
  text-align: center;
}
</style>
</head>
<body>
<div>
<form action="Password_check">
Enter Current Password: <input type="text" name="current_password">
<br/><br/>
Enter New Password: <input type="text" name="new_password">
<br/><br/>
Confirm New Password: <input type="text" name="confirm_new_password">
<br/><br/>
<input type="submit" value="Change Password">
</form>
</div>
</body>
</html>