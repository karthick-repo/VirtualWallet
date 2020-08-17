<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Topup virtual card</title>
<link rel="stylesheet" type="text/css" href="formstyle.css" />
<%@include file="navbar.jsp"%>
</head>
<body>
	<h3>Topup Virtual Card</h3><br><br><br><br>
	<form  method="POST" action="topupvalidate">
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
		<input type="text" id=amount name=amount><br> <br>
		<%
			if (k != 0) {
		%>
		<input type="submit" value="Topup Card" />
		<%
			}
		%>
		<%
			if (k == 0) {
		%>
		<p style="color: red; text-align: center">No Cards Created</p><br>
		<button type="button" disabled>Topup Card</button>
		<%
			}
		%>
	</form>
</body>
</html>