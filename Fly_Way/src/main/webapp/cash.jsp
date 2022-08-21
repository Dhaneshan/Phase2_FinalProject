<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
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
<form>
Enter Card Number: <input type="text" name="cnum">
<br/><br/>
Enter Expiry Date: <input type="text" name="edate">
<br/><br/>
Enter CVV: <input type="text" name="cvv">
<br/><br/>
<a href="Successful.jsp">Pay</a>
</form>
</div>
</body>
</html>