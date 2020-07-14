<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<%@include file="navbar.jsp"%>
<title>Virtual Card Error</title>
</head>
<body>
<p>${msg}</p>

<form method="POST" action="view_cards">
		<input type="submit" value="Viewcards" />
	</form>
</body>
</html>