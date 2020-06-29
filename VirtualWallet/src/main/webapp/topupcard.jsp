<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Topup virtual card</title>
<link rel="stylesheet" type="text/css" href="style.css" />
<%@include file="navbar.jsp"%>
</head>
<body>
	<h2>Topup Virtual Card</h2>
	<form action="topupsuccess">
		<label>Select Card</label>
		<%
			int k = (int) request.getAttribute("key");
		%>
		<label for="MyCard"></label> <select name="cardname">
			<%
				if (k == 0) {
			%>
			<option>None</option>
			<%
				}
			if (k == 1) {
			%>
			<option value="${allcards.get(0)}">${allcards.get(0)}</option>
			<%
				}
			if (k == 2) {
			%>
			<option value="${allcards.get(0)}">${allcards.get(0)}</option>
			<option value="${allcards.get(1)}">${allcards.get(1)}</option>
			<%
				}
			if (k == 3) {
			%>
			<option value="${allcards.get(0)}">${allcards.get(0)}</option>
			<option value="${allcards.get(1)}">${allcards.get(1)}</option>
			<option value="${allcards.get(2)}">${allcards.get(2)}</option>
			<%
				}
			%>
		</select> <br> <br> <label>Select Account</label> <label
			for="selectaccount"></label> <select id="selectaccount">
			<option value="My Wallet ">My Wallet</option>
		</select> <br> <br> 
		<label>Amount</label> 
		<input type="text" id=amount name=amount><br> <br> <input
			type="submit" value="Topup card" />
	</form>
</body>
</html>