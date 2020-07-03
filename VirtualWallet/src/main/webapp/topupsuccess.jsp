<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="navbar.jsp"%>
</head>
<body>
<h2>TopUp Successful</h2>

<label>Card Name</label>
<p>${Card_Name}</p>
<label>Card Number</label>
<p>${Card_Number}</p>
<label>Card Balance</label>
<p>${Card_Balance}</p>

<form action="view_cards">
		<input type="submit" value="Viewcards" />
	</form>
</body>
</html>