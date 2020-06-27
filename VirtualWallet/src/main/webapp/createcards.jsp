<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create cards</title>
<%@include file="navbar.jsp"%>
</head>
<body>
	<h2>Create New VirtualCard</h2>
	<form action="createcards">
		<div align="center">
			<input type="hidden" id="userid" name="userid" value="${userid}"
				required><br />
			<br /> <input type="hidden" id="cardnumber" name="cardnumber"
				value="${cardnumber}" required><br />
			<br /> <input type="hidden" id="date" name="date" value="${date}"
				required><br />
			<br /> Amount : <input type="number" name="amount" id="amount"
				required /><br />
			<br /> Card Name : <input type="text" name="cardname" id="cardname"
				required><br />
			<br /> select Account: <label for="selectaccount"></label> <select
				id="selectaccount">
				<option value="My Wallet ">My Wallet</option>
			</select> <br>
			<br> <input type="submit" value="Create card" />
		</div>
	</form>

</body>
</html>