<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="navbar.jsp"%>

</head>
<body>
	<h2>Virtual card created</h2>
	<p>
		Card Name :${cardname} <br>
		<br> Card Number : ${cardnumber} <br>
		<br> Expiry on : ${date} <br>
		<br> Card Balance : ${cardBalance}
	</p>
	<form  action="view_cards">
		<input type="submit" value="Viewcards" />
	</form>

</body>
</html>