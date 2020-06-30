<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="navbar.jsp"%>
<title>Virtual Wallet-Home</title>
</head>
<div style="width: 300px; height: 130px; border: 1px solid #000;">
    <h4>My Wallet</h4>
	<label>Available Balance</label> <br><br>
	<label id="wallet-balance">${amount}</label>
		
</div>
<div style="width: 300px; height: 130px; border: 1px solid #000;">
<h4>Cards</h4>
	<label>Available Cards </label><br>
	<br>
	<label id="cards-remaining">${tcards}</label>
</div>
</body>
</html>