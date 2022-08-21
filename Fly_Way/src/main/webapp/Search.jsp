<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Flight Search</title>
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
<link href="style/Div.css" rel="stylesheet" type="text/css">
</head>
<body>
<div>
    <form action="Flight_Search">
       <br>
       <br>
       Enter the date of Travel : <input type="text" name="Date">
       <br>
       <br>
       Enter the place of Departure :  <input type="text" name="Dep">
       <br>
       <br>
       Enter the place of Arrive : <input type="text" name="Arr">
       <br>
       <br>
       Enter the No of Passenger: <input type="number" name="No">
       <br/>
       <br/>
      <input type="submit" value="Search">
    </form>
</div>
</body>
</html>