<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topup virtual card</title>
<%@include file="navbar.jsp" %>
</head>
<body>
<h2>Topup Virtual Card</h2>
<form action="topupcard">
select Card:
<label for="MyCard"></label>
<select id="MyCard">
  <option value="MyCard">MyCard</option>
</select>
<br><br>
select Account:
<label for="selectaccount"></label>
<select id="selectaccount">
  <option value="My Wallet ">My Wallet</option>
</select>
<br><br>
<!-- Amount(Select from below or enter the amount)
<br><br>
<button  onclick=enteredamount.value=100>100</button>
<button Value="500">500</button>
<button Value="1000">1000</button>
 -->
<br><br>
<input type="text"  id=enteredamount name=enteredamount >

<br><br>
<input type="submit" value="Topup card" />
</form>
</body>
</html>